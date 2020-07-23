package Contest.Contest15.Problem3;

/**
 * 我们需要使用一个 dpdp 矩阵，其中 dp(i, j)dp(i,j) 代表在 (i, j)(i,j) 中最坏情况下最小开销的代价。
 * 现在我们只需要考虑如何求出这个 dp 数组。如果区间只剩下一个数 k ，那么猜中的代价永远为 0 ，因为我们区间里只剩下一个数字，也就是说，所有的 dp(k, k)dp(k,k) 都初始化为 0 。
 * 然后，对于长度为 2 的区间，我们需要所有长度为 1 的区间的结果。
 * 由此我们可以看出，为了求出长度为 lenlen 区间的解，我们需要所有长度为 len-1 的解。因此我们按照区间长度从短到长求出 dp 数组。
 *
 * cost(i,j)=pivot+max(cost(i,pivot−1),cost(pivot+1,n))
 */
class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int minres = Integer.MAX_VALUE;
                for (int piv = start; piv < start + len - 1; piv++) {
                    int res = piv + Math.max(dp[start][piv - 1], dp[piv + 1][start + len - 1]);
                    minres = Math.min(res, minres);
                }
                dp[start][start + len - 1] = minres;
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getMoneyAmount(10));
    }
}