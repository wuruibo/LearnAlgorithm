package DynamicProgramming.P70;

class Solution {
    /**
     * 简单递归 时间复杂度n2
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return climbStairs(n-1)+climbStairs(n-2);
    }

    /**
     * using 动态规划 时间复杂度n
     * 空间复杂度n
     * @param n
     * @return
     */
    public int climbStairsUsingDP(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int[] dp=new int[n];
        dp[0]=1;dp[1]=2;
        for(int i=2;i<n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n-1];
    }
    /**
     * using 动态规划 时间复杂度n
     * 空间复杂度n 可不可以减少？那就只保留两个值吧
     * @param n
     * @return
     */
    public int climbStairsUsingDPLess(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int tempN2=1;int tempN1=2;
        int tempN=0;
        for(int i=2;i<n;i++){
            tempN=tempN1+tempN2;
            tempN2= tempN1;
            tempN1=tempN;
        }
        return tempN;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(5));
        System.out.println(new Solution().climbStairsUsingDP(5));
        System.out.println(new Solution().climbStairsUsingDPLess(5));
    }
}