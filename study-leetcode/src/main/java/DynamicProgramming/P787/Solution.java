package DynamicProgramming.P787;

import java.util.*;

class Solution {
    private Map<Integer, List<int[]>> graph= new HashMap<>();
    private Map<String,Integer> dpMap=new HashMap<>();
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        //先构造一个树
        for (int i = 0; i < flights.length; i++) {
            int[] current=flights[i];
            int destination=current[1];
            int[] source=new int[]{current[0],current[2]};
            //加入到list中
            List<int[]> sources=graph.getOrDefault(destination, new ArrayList<>());
            sources.add(source);
            graph.put(destination,sources);
        }
        return dfs(dst,src,K);
    }
    private int dfs(int dest,int src,int k){
        String key= Arrays.stream(new Integer[]{dest, src, k})
                .map(String::valueOf)
                .reduce((a,b)-> a+"-"+b).get();

        if (dest==src) {
            return 0;
        }
        if (k==-1){
            return -1;
        }
        if (dpMap.containsKey(key)) {
            return dpMap.get(key);
        }
        List<int[]> sources=graph.get(dest)==null?new ArrayList<>():graph.get(dest);
        Integer min=sources.stream()
                .map(ints -> {
                    int subMax=dfs(ints[0],src,k-1);
                    return subMax<0?subMax:(ints[1]+subMax)%1000000007;
                })
                .filter(integer -> integer>=0)
                .min(Integer::compareTo)
                .orElse(-1);
        dpMap.put(key,min);
        return min;
    }

    public static void main(String[] args) {
/*        System.out.println(new Solution().findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1));
        System.out.println(new Solution().findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 0));
        System.out.println(new Solution().findCheapestPrice(5, new int[][]{{4,1,1},{1,2,3},{0,3,2},{0,4,10},{3,1,1},{1,4,3}}, 2, 1, 1));*/
        System.out.println(new Solution().findCheapestPrice(2, new int[][]{{1,0,5}}, 0, 1, 1));
    }
}