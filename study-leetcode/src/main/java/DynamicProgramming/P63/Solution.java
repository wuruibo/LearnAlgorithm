package DynamicProgramming.P63;

/**
 * 所以一个问题是该用递推、贪心、搜索还是动态规划，完全是由这个问题本身阶段间状态的转移方式决定的！
 * 每个阶段只有一个状态->递推；
 * 每个阶段的最优状态都是由上一个阶段的最优状态得到的->贪心；
 * 每个阶段的最优状态是由之前所有阶段的状态的组合得到的->搜索；
 * 每个阶段的最优状态可以从之前某个阶段的某个或某些状态直接得到而不管之前这个状态是如何得到的->动态规划。
 *
 *
 *
 * 动态规划解决问题：
 * 1.递归容易导致栈溢出
 * 2.避免重复子运算导致时间复杂度指数增长
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length==0) {
            return 0;
        }
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //如果当前位置有墙 表示不能走
                if (obstacleGrid[i][j]==1) {
                    dp[i][j]=0;
                }else {
                    if(i==0 && j==0){
                        dp[i][j]=1;
                    }else if (i == 0) {
                        dp[i][j] = dp[i][j-1];
                    }else if (j==0){
                        dp[i][j] = dp[i-1][j];
                    }else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
        }
        return dp[n - 1][m - 1];
    }



    public static void main(String[] args) {
        int[][] ints={{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(new Solution().uniquePathsWithObstacles(ints));

        int[][] ints1={{1,0}};
        System.out.println(new Solution().uniquePathsWithObstacles(ints1));
    }
}