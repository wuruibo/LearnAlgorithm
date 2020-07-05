package Contest.Contest7.Problem3.P1277;

/**
 * 1.动态规划求解，核心是定义好dp的含义以及状态转移方程，dp[i][j]表示以(i,j)位置为右下角边界点所构成的正方形的最大边长。
 * 2.状态转移方程：dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])+1
 * 3.对于位置(i,j), 以该点作为右下角边界点所对应的正方形的数量刚好就是dp[i][j]
 */
class Solution {
	public int countSquares(int[][] matrix) {
		int row = matrix.length, col = matrix[0].length, res = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 0) continue;
				if (i - 1 >= 0 && j - 1 >= 0) {
					matrix[i][j] = Math.min(Math.min(matrix[i][j - 1], matrix[i - 1][j]), matrix[i - 1][j - 1]) + 1;
				}
				res += matrix[i][j];
			}
		}
		return res;
	}
}