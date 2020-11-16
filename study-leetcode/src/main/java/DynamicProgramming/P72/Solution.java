package DynamicProgramming.P72;

/**
 *
 *
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 *
 *
 *
 * 解题思路:
 *
 *
 * Let following be the function definition :-
 *
 * f(i, j) := minimum cost (or steps) required to convert first i characters of word1 to first j characters of word2
 *
 * Case 1: word1[i] == word2[j], i.e. the ith the jth character matches.
 *
 * f(i, j) = f(i - 1, j - 1)
 *
 * Case 2: word1[i] != word2[j], then we must either insert, delete or replace, whichever is cheaper
 *
 * f(i, j) = 1 + min { f(i, j - 1), f(i - 1, j), f(i - 1, j - 1) }
 *
 * f(i, j - 1) represents insert operation
 * f(i - 1, j) represents delete operation
 * f(i - 1, j - 1) represents replace operation
 * Here, we consider any operation from word1 to word2. It means, when we say insert operation, we insert a new character after word1 that matches the jth character of word2. So, now have to match i characters of word1 to j - 1 characters of word2. Same goes for other 2 operations as well.
 *
 * Note that the problem is symmetric. The insert operation in one direction (i.e. from word1 to word2) is same as delete operation in other. So, we could choose any direction.
 *
 * Above equations become the recursive definitions for DP.
 *
 * Base Case:
 *
 * f(0, k) = f(k, 0) = k
 *
 *
 *
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word2.length()+1][word1.length()+1];
        for(int i = 0; i <= word2.length(); i++) {
            for(int j = 0; j <= word1.length(); j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = 0; // no strings given
                } else if(i == 0 && j != 0) {
                    dp[i][j] = j; // word2 is empty
                } else if(i != 0 && j == 0) {
                    dp[i][j] = i; // word1 is empty
                } else if(word2.charAt(i-1) != word1.charAt(j-1)) {
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])) + 1;
                }else {
                    dp[i][j] = dp[i-1][j-1]; // same characters just carry over previous chars from both
                }
            }
        }
        return dp[word2.length()][word1.length()];
    }
}