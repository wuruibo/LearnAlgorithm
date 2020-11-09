package 剑指offer.三步问题;

class Solution {
    public int waysToStep(int n) {
        long[] dp=new long[n+1];
        dp[0]=1;
        for (int i = 1; i <= n; i++) {
            if (i<=2) {
                dp[i]=i;
            }else {
                dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3])%1000000007;
            }
        }
        return (int)dp[n];
    }

    /**
     * int 最大值 2147483647
     * 两个1000000007不会超过2147483647
     * 三个1000000007会超过2147483647
     * @param n
     * @return
     */
    public int waysToStepGrid(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        for (int i = 1; i <= n; i++) {
            if (i<=2) {
                dp[i]=i;
            }else {
                dp[i] = (dp[i - 1]+ dp[i - 2])%1000000007 + dp[i - 3]%1000000007;
            }
        }
        return dp[n];
    }
}