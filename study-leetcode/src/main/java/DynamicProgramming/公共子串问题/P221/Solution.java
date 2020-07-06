package DynamicProgramming.公共子串问题.P221;

/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        //定义dp问题 表示i，j位置的以右下角为底的子矩阵中最大的为1的边长
        int[][] dp=new int[matrix.length][matrix[0].length];
        int max=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j==0 || i==0) {
                    dp[i][j]=matrix[i][j];
                }else if(matrix[i][j]==0){
                    continue;
                }else {
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
                max=Math.max(max,dp[i][j]);
            }
        }
        return max*max;
    }

    public static void main(String[] args) {
        char[][] chars= {{1,0,1,0,0},
        {1,0,1,1,1},
        {1,1,1,1,1},
        {1,0,0,1,0}};
        System.out.println(new Solution().maximalSquare(chars));
    }
}