package Contest.Contest50.Problem2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        //构建图
        int m=adjacentPairs.length;
        Map<Integer, Set<Integer>> graphs= new HashMap<>(12);
        for (int i = 0; i < m; i++) {
            int u=adjacentPairs[i][0],v=adjacentPairs[i][1];
            graphs.putIfAbsent(u, new HashSet<>());
            graphs.putIfAbsent(v, new HashSet<>());
            graphs.get(u).add(v);
            graphs.get(v).add(u);
        }
        //先找到头/尾 出现次数为1的节点为头/尾
        Integer start=graphs.keySet().stream().filter(key->graphs.get(key).size()==1).findFirst().get();
        //删除部分节点
        int[] result=new int[m+1];
        for (int i = 0; i < result.length; i++) {
            result[i]=start;
            Set<Integer> set=graphs.get(start);
            if (!set.isEmpty()) {
                Integer value=set.stream().findFirst().get();

                Set<Integer> nextSet=graphs.get(value);
                nextSet.remove(start);
                start=value;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().restoreArray(new int[][]{{2, 1}, {3, 4}, {3, 2}}));
        System.out.println(new Solution().restoreArray(new int[][]{{4,-2},{1,4},{-3,1}}));
        System.out.println(new Solution().restoreArray(new int[][]{{100000,-100000}}));
    }
}