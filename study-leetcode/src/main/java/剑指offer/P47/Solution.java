package 剑指offer.P47;

/**
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 */
class Solution {
    public int maxValue(int[][] grid) {
        if (grid.length==0) {
            return 0;
        }
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        //初始化
        dp[0][0]=grid[0][0];
        for (int j = 1; j < m; j++) {
            dp[0][j]=dp[0][j-1]+grid[0][j];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxValue(new int[][]{{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}}));
    }
}