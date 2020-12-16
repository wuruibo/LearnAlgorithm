package DynamicProgramming.P375;

class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp=new int[n+1][n+1];
        //从列开始
        for (int j = 1; j <= n; j++) {
            for (int i = j-1; i >= 1; i--) {
                if (i==j) {
                    dp[i][j]=0;
                }else {
                    //算两端
                    dp[i][j]=Math.min(j+dp[i][j-1],i+dp[i+1][j]);
                    for (int k = i+1; k <= j-1; k++) {
                        dp[i][j]=Math.min(dp[i][j],Math.max(dp[i][k-1],dp[k+1][j])+k);
                    }
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getMoneyAmount(10));
    }
}