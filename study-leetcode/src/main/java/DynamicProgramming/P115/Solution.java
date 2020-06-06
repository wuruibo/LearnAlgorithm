package DynamicProgramming.P115;

/**
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * Example 1:
 *
 * Input: S = "rabbbit", T = "rabbit"
 * Output: 3
 * Explanation:
 *
 * As shown below, there are 3 ways you can generate "rabbit" from S.
 * (The caret symbol ^ means the chosen letters)
 *
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * Example 2:
 *
 * Input: S = "babgbag", T = "bag"
 * Output: 5
 * Explanation:
 *
 * As shown below, there are 5 ways you can generate "bag" from S.
 * (The caret symbol ^ means the chosen letters)
 *
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 *   ^  ^^
 * babgbag
 * ^^^
 *
 * 根据状态转移方程先写一个版本
 */
class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp=new int[t.length()+1][s.length()+1];
        //初始化
        for (int i = 0; i <=s.length(); i++) {
            dp[0][i]=1;
        }
        for (int i = 1; i <= t.length(); i++) {
            for (int j = i; j <=s.length(); j++) {
                if (t.charAt(i-1)==s.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1]+dp[i][j-1];
                }else if(t.charAt(i-1)!=s.charAt(j-1)){
                    dp[i][j]=dp[i][j-1];
                }
            }
        }

        return dp[t.length()][s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDistinct("rabbbit","rabbit"));
        System.out.println(new Solution().numDistinct("babgbag","bag"));
    }
}