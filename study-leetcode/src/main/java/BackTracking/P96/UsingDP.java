package BackTracking.P96;

/**
 * 就跟斐波那契数列一样，我们把n = 0 时赋为1，因为空树也算一种二叉搜索树，那么n = 1时的情况可以看做是其左子树个数乘以右子树的个数，左右字数都是空树，所以1乘1还是1。那么n = 2时，由于1和2都可以为跟，分别算出来，再把它们加起来即可。n = 2的情况可由下面式子算出：
 *
 * dp[2] =  dp[0] * dp[1]　　　(1为根的情况)
 *
 * 　　　　+ dp[1] * dp[0]　　  (2为根的情况)
 *
 * 同理可写出 n = 3 的计算方法：
 *
 * dp[3] =  dp[0] * dp[2]　　　(1为根的情况)
 *
 * 　　　　+ dp[1] * dp[1]　　  (2为根的情况)
 *
 *  　　　  + dp[2] * dp[0]　　  (3为根的情况)
 */
public class UsingDP {
    public int numTrees(int n) {
        int fun[] = new int[n + 1];
        fun[0] = 1;
        fun[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                fun[i]=fun[i]+fun[j]*fun[i-1-j];
            }
        }
        return fun[n];

    }
}
