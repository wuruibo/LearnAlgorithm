package DynamicProgramming.完全背包问题.硬币.滚动数组优化版本;

class Solution {
    public int waysToChange(int n) {
        
        int[] dp = new int[n + 1];
        
        int[] coins = new int[]{1,5,10,25};
        
        
        //刚好可以用一个硬币凑成的情况，是一种情况
        // while i == coin :
        //dp[i] = dp[i - coin] => dp[0]
        dp[0] = 1;
        
        /**
        * dp方程：dp[i] += dp[i - coin];
        */
        
        for(int i = 1; i <= n; i++) {
            for(int coin: coins) {
                if(i - coin < 0) {
                    break;
                }
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }
        
        return dp[n];
    }
}