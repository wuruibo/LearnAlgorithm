package DynamicProgramming.P474;

class Solution {
    /**
     * 类似01背包问题
     * dp[i][j]表示0的数量为i和1的数量为j的时候对应的最长子串长度
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {    // 每个字符串只能用一次
            int ones = 0, zeros = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
    private int[] count(String str){
        int[] hash=new int[2];
        for (char c : str.toCharArray()) {
            hash[c-'0']++;
        }
        return hash;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
        System.out.println(new Solution().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }
}