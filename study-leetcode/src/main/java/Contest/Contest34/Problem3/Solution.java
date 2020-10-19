package Contest.Contest34.Problem3;

/**
 * 输入：n = 4, k = 2
 * 输出：5
 * 解释：
 * 如图所示，两个线段分别用红色和蓝色标出。
 * 上图展示了 5 种不同的方案 {(0,2),(2,3)}，{(0,1),(1,3)}，{(0,1),(2,3)}，{(1,2),(2,3)}，{(0,1),(1,2)} 。
 * 示例 2：
 *
 * 输入：n = 3, k = 1
 * 输出：3
 * 解释：总共有 3 种不同的方案 {(0,1)}, {(0,2)}, {(1,2)} 。
 * 示例 3：
 *
 * 输入：n = 30, k = 7
 * 输出：796297179
 * 解释：画 7 条线段的总方案数为 3796297200 种。将这个数对 109 + 7 取余得到 796297179 。
 * 示例 4：
 *
 * 输入：n = 5, k = 3
 * 输出：7
 * 示例 5：
 *
 * 输入：n = 3, k = 2
 * 输出：1
 */
class Solution {
    public int numberOfSets(int n, int k) {

        // dp[i][j] = dp[i-1][j] + (dp[0][j-1] + ... + dp[i-1][j-1])       ----Eq. 1
        // dp[i-1][j] = dp[i-2][j] + (dp[0][j-1] + ... + dp[i-2][j-1])     ----Eq. 2
        // 0 = dp[i-2][j] + (dp[0][j-1] + ... + dp[i-2][j-1]) - dp[i-1][j] ----Eq. 2*
        // dp[i][j] = 2 * dp[i-1][j] + dp[i-1][j-1] - dp[i-2][j]           ----Eq. (1 - 2*)
        int[][] dp=new int[1000][1000];
        int mod = 1000000007 + 7;
        for(int i = 0;i < n;++i) {
            for(int j = 0;j < k + 1;++j) {
                if (j==0) {
                    dp[i][j]=1;
                }
            }
        }
        dp[1][1] = 1;
        for(int i = 2;i < n;++i) {
            for(int j = 1;j < k + 1;++j) {
                dp[i][j] = 2*dp[i-1][j] + dp[i-1][j-1] - dp[i-2][j];
                dp[i][j] %= mod;
            }
        }
        return (dp[n-1][k] + mod) % mod;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfSets(4, 2));
        System.out.println(new Solution().numberOfSets(3, 1));
        System.out.println(new Solution().numberOfSets(30, 7));
        System.out.println(new Solution().numberOfSets(5, 3));
        System.out.println(new Solution().numberOfSets(3, 2));
    }
}