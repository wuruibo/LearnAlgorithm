package Contest.Contest38.Problem1;

class Solution {
    public int getMaximumGenerated(int n) {
        int[] dp=new int[n+1];
        int max=0;
        for (int i = 0; i <= n; i++) {
            if (i==1) {
                dp[i]=1;
            }else if (i%2==0) {
                dp[i]=dp[i/2];
            }else {
                dp[i]=dp[i/2]+dp[i/2+1];
            }
            max=Math.max(dp[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getMaximumGenerated(7));
        System.out.println(new Solution().getMaximumGenerated(0));
        System.out.println(new Solution().getMaximumGenerated(1));
        System.out.println(new Solution().getMaximumGenerated(2));
        System.out.println(new Solution().getMaximumGenerated(3));
    }
}