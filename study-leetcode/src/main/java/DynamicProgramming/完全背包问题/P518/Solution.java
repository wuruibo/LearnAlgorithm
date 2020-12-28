package DynamicProgramming.完全背包问题.P518;

import java.util.Arrays;

/**
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 */
class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length+1][amount+1];
        Arrays.sort(coins);
        //初始化
        for (int i = 0; i < dp.length; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j]=dp[i-1][j];;
                if (j-coins[i-1]>=0) {
                    dp[i][j]+=dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().change(5, new int[]{1, 2, 5}));
    }
}