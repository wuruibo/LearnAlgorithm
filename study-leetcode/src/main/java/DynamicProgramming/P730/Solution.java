package DynamicProgramming.P730;

/**
 * @author yeqiaozhu
 * @date today
 * 区间dp 状态方程比较难找
 * https://leetcode-cn.com/problems/count-different-palindromic-subsequences/solution/dong-tai-gui-hua-dui-qu-jian-dpfen-lei-tao-lun-by-/
 */
public class Solution {
    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        int[][] dp = new int[n][n]; // dp[i][j]表示[i,j]下标范围内的回文子序列数量
        char[] ch = s.toCharArray();
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (ch[i] != ch[j]) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                } else {
                    dp[i][j] = dp[i + 1][j - 1] * 2;
                    int l = i + 1, r = j - 1;
                    while (l <= r && ch[l] != ch[i]) {
                        l += 1;
                    }
                    while (l <= r && ch[r] != ch[i]) {
                        r -= 1;
                    }
                    if (l > r) {
                        dp[i][j] += 2; // "bcab"
                    } else if (l == r) {
                        dp[i][j] += 1; // "bcbcb"
                    } else {
                        dp[i][j] -= dp[l + 1][r - 1]; // l < r , "bbcabb"
                    }
                }
                dp[i][j] = dp[i][j] < 0 ? dp[i][j] + 1000000007 : dp[i][j] % 1000000007;
            }
        }
        return dp[0][n - 1];
    }
}
