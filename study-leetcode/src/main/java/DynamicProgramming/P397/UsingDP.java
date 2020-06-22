package DynamicProgramming.P397;

/**
 * 消除重复子问题
 *
 * 但是内存直接爆了
 */
public class UsingDP {
    public int integerReplacement(int n) {
        int[] dp=new int[n+1];
        dp[1]=0;
        for (int i = 2; i <= n; i++) {
            if ((i&1)==0) {
                dp[i]=dp[i>>1]+1;
            }else {
                dp[i]=Math.min(dp[(i+1)>>1]+1,dp[i-1])+1;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new UsingDP().integerReplacement(8));
        System.out.println(new UsingDP().integerReplacement(7));
    }
}
