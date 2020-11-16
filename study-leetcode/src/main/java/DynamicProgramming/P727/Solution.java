package DynamicProgramming.P727;

/**
 * 输入：
 * S = "abcdebdde", T = "bde"
 * 输出："bcde"
 * 解释：
 * "bcde" 是答案，因为它在相同长度的字符串 "bdde" 出现之前。
 * "deb" 不是一个更短的答案，因为在窗口中必须按顺序出现 T 中的元素。
 *
 */
class Solution {
    public String minWindow(String S, String T) {
        int n = T.length();
        int[][] dp = new int[S.length() + 1][T.length() + 1];
        //dp[i][j] length of minmum W of S:(0~i) ending with S[i]
        // that contains T[0 : j]
        S = "#" + S;
        T = "#" + T;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = S.length() + 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (S.charAt(i) == T.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 这里 加1 是 i - 1包含了t ,  但是这里是已i结尾 ，所以 加上这个i的长度1
                    dp[i][j] = dp[i - 1][j] + 1;
                }
            }
        }
        int minLen = S.length() + 1;
        int pos = -1;
        for (int i = 1; i < dp.length; i++) {
            if (dp[i][n] < minLen) {
                minLen = dp[i][n];
                pos = i;
            }
        }
        if (minLen == S.length() + 1) {
            return "";
        }
        return S.substring(pos - minLen + 1, pos + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("abcdebdde", "bde"));
        System.out.println(new Solution().minWindow("jmeqksfrsdcmsiwvaovztaqenprpvnbstl", "k"));
    }
}