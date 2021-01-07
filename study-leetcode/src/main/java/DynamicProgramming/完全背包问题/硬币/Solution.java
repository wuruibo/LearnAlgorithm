package DynamicProgramming.完全背包问题.硬币;

/**
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 *  输入: n = 10
 *  输出：4
 *  解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 */
class Solution {
    public int waysToChange(int n) {
        //dp[i][j]表示i种硬币 币值为j最多可以凑几种 dp[i][j]=dp[i-1][j-value[i]]+dp[i][j-value[i]]
        int[] value=new int[]{1,5,10,25};
        int[][] dp=new int[5][n+1];
        //初始化 如果当前需要凑的金额是0 说明这是一种方案
        for (int i = 0; i < dp.length; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i <= value.length; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j]=dp[i-1][j]%1000000007;
                if (j-value[i-1]>=0) {
                    dp[i][j]+=dp[i][j-value[i-1]]%1000000007;
                    dp[i][j]%=1000000007;
                }
            }
        }
        return dp[4][n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().waysToChange(10));
        System.out.println(new Solution().waysToChange(900750));
        System.out.println(new Solution().waysToChange(929782));
    }
}