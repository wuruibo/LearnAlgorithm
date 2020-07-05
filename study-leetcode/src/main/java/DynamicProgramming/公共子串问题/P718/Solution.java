package DynamicProgramming.公共子串问题.P718;

/**
 * 718. 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 *
 *
 * 示例：
 *
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 *
 *
 * 提示：
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 */
class Solution {
    public int findLength(int[] A, int[] B) {
        int[][] dp=new int[A.length+1][B.length+1];
        int[][] temp=new int[A.length+1][B.length+1];

        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= B.length; j++) {
                if (i==0 || j==0) {
                    dp[i][j]=0;temp[i][j]=0;
                }else if (A[i-1]!=B[j-1]) {
                    temp[i][j]=temp[i-1][j-1];
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }else if (A[i-1]==B[j-1]){
                    temp[i][j]=temp[i-1][j-1]+1;
                    dp[i][j]=Math.max(dp[i-1][j-1],Math.max(dp[i][j-1],dp[i-1][j]));
                    dp[i][j]=Math.max(temp[i-1][j-1]+1,dp[i][j]);
                }
            }
        }

        return dp[A.length][B.length];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }
}