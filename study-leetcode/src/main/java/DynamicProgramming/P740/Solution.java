package DynamicProgramming.P740;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> numsMap = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.summingInt(Integer::intValue)));
        Integer[] keys = numsMap.keySet().stream().sorted().toArray(Integer[]::new);
        int n=keys.length,max;
        int[][] dp=new int[n+1][2];
        for (int i = 1; i <= n; i++) {
            if(i>1 && keys[i-1]-keys[i-2]>1){
                dp[i][1]= Math.max(dp[i - 1][1],dp[i-1][0]) + numsMap.get(keys[i - 1]);
            }else {
                dp[i][1] = dp[i - 1][0] + numsMap.get(keys[i - 1]);
            }
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
        }
        max=Math.max(dp[n][0],dp[n][1]);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().deleteAndEarn(new int[]{1,6,3,3,8,4,8,10,1,3}));
        System.out.println(new Solution().deleteAndEarn(new int[]{1,1,1,2,4,5,5,5,6}));
        System.out.println(new Solution().deleteAndEarn(new int[]{3,4,2}));
        System.out.println(new Solution().deleteAndEarn(new int[]{2,4,6}));
        System.out.println(new Solution().deleteAndEarn(new int[]{2,2,3,3,3,4}));
    }
}