package DynamicProgramming.P1049;

import java.util.Arrays;

/**
 * 朴实版本 三维数组
 *
 * 转换为01背包问题 求不超过sum/2的重量的背包最多能装多少
 * dp[0][i][w]表示第i+1个位置剩余w的重量选择不背的最大收益
 * dp[1][i][w]表示第i+1个位置剩余w的重量选择背的最大收益
 *
 *
 * 进阶版本 二维数组
 * dp[i][w]表示第i+1个位置剩余w的重量选或者不选的最大收益
 *
 *
 * 滚动数组版本 一维数组
 *
 */
class Solution {
    /**
     * 最朴实版本01背包
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        int sum=Arrays.stream(stones).sum();
        int weight=Arrays.stream(stones).sum()/2;
        int[][][] dp=new int[2][stones.length+1][weight+1];
        int max=0;
        for (int i = 1; i <= stones.length; i++) {
            for (int j = 1; j <= weight; j++) {
                int current=stones[i-1];
                if (current<=j) {
                    dp[0][i][j] = Math.max(dp[0][i - 1][j], dp[1][i - 1][j]);
                    dp[1][i][j] = Math.max(dp[0][i - 1][j - current], dp[1][i - 1][j - current])+current;
                }else {
                    dp[0][i][j] = Math.max(dp[0][i - 1][j], dp[1][i - 1][j]);
                }
                max=Math.max(Math.max(dp[0][i][j],dp[1][i][j]),max);
            }
        }
        return sum-2*max;
    }

    /**
     * 进阶版
     * @param stones
     * @return
     */
    public int lastStoneWeightIIVersion(int[] stones) {
        int sum=Arrays.stream(stones).sum();
        int w=sum/2;
        int[][] dp=new int[stones.length+1][w+1];
        for (int i = 1; i <= stones.length; i++) {
            for (int j = 1; j <= w; j++) {
                int current=stones[i-1];
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j]);
                if (j>=current) {
                    dp[i][j]=Math.max(dp[i-1][j-current]+current,dp[i][j]);
                }
            }
        }
        return sum-2*dp[stones.length][w];
    }
    public int lastStoneWeightIIVersion2(int[] stones) {
        int sum=Arrays.stream(stones).sum();
        int w=sum/2;
        /* 定义 dp[i] 重量上限为 i 时背包所能装载的最大石头重量 */
        int[] dp=new int[w+1];
        for (int i = 0; i < stones.length; i++) {
            int curStone = stones[i];
            for (int j = w; j >= curStone; j--) {
                dp[j] = Math.max(dp[j], dp[j-curStone] + curStone);
            }
        }
        return sum - 2 * dp[w];
    }
    public static void main(String[] args) {
        System.out.println(new Solution().lastStoneWeightII(new int[]{2,7,4,1,8,1}));
        System.out.println(new Solution().lastStoneWeightIIVersion(new int[]{2,7,4,1,8,1}));
        System.out.println(new Solution().lastStoneWeightIIVersion2(new int[]{2,7,4,1,8,1}));
    }
}