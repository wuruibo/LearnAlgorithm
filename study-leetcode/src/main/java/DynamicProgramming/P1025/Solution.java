package DynamicProgramming.P1025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private Map<String,Boolean> dpMap= new HashMap<>();
    public boolean divisorGame(int N) {
       return dfs(N,0);
    }

    /**
     * dfs
     * @param N 数量
     * @param person 当前应该谁来选
     * @return
     */
    private boolean dfs(int N,int person){
        String key=N+"-"+person;
        if (dpMap.containsKey(key)) {
            return dpMap.get(key);
        }
        boolean result=false;
        if (N<=1 && person==1){
            result=true;
        }else if (N<=1 && person==0){
            result=false;
        }else {
            //选出N当中所有可选的数字 也就是所有的公约数
            List<Integer> next=getAll(N);
            for (int i = 0; i < next.size(); i++) {
                int current=next.get(i);
                if (dfs(N-current,person^1)) {
                    result=true;
                }
            }
        }
        dpMap.put(key,result);
        return result;
    }
    private List<Integer> getAll(int N){
        List<Integer> result= new ArrayList<>();
        for (int i = 1; i < N; i++) {
            if (N%i==0) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().divisorGame(2));
        System.out.println(new Solution().divisorGame(3));

        System.out.println(new Solution().divisorGame(5));
        System.out.println(new Solution().divisorGame(2));
        System.out.println(new Solution().divisorGame(3));
        System.out.println(new Solution().divisorGame(6));
    }
}