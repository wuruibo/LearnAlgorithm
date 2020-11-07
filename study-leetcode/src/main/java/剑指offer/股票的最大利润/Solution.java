package 剑指offer.股票的最大利润;

import java.util.Arrays;

/**
 * 定义dp问题 dp[0][i]表示在i位置未持有股票的最大收益 dp[1][i]表示在i位置持有股票的最大收益
 */
class Solution {
    /**
     * 目前只能要求买卖一次
     * @param prices
     * @return
     */
    public int maxProfitMore(int[] prices) {
        if (prices.length==0) {
            return 0;
        }
        int[][] dp=new int[2][prices.length];
        for (int i = 0; i < prices.length; i++) {
            if (i==0) {
                dp[1][0]=-prices[i];
            }else {
                dp[0][i] = Math.max(dp[1][i - 1] + prices[i], dp[0][i - 1]);
                dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] - prices[i]);
            }
        }
        return dp[0][prices.length-1];
    }
    public int maxProfit(int[] prices) {
        if (prices.length==0) {
            return 0;
        }
        int[][] dp=new int[2][prices.length];
        for (int i = 0; i < prices.length; i++) {
            if (i==0) {
                dp[1][0]=-prices[i];
            }else {
                dp[0][i] = dp[1][i - 1] + prices[i];
                dp[1][i] = Math.max(dp[1][i - 1],-prices[i]);
            }
        }
        return Arrays.stream(dp[0])
                .boxed()
                .max(Integer::compareTo)
                .get();
    }
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(new Solution().maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(new Solution().maxProfit(new int[]{}));
    }
}