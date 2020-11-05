package DynamicProgramming.P474;

/**
 * @author yeqiaozhu
 * @date today
 */
public class NotClean {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 1; i <= strs.length; i++) {
            int count0 = 0, count1 = 0;
            for (char ch : strs[i - 1].toCharArray()) {
                if (ch == '0') {
                    count0++;
                }
            }
            count1 = strs[i - 1].length() - count0;
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (count0 <= j && count1 <= k) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], 1 + dp[i - 1][j - count0][k - count1]);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }
}
