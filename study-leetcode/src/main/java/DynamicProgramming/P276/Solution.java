package DynamicProgramming.P276;

/**
 * 有 k 种颜色的涂料和一个包含 n 个栅栏柱的栅栏，每个栅栏柱可以用其中一种颜色进行上色。
 *
 * 你需要给所有栅栏柱上色，并且保证其中相邻的栅栏柱 最多连续两个 颜色相同。然后，返回所有有效涂色的方案数。
 *
 * 注意:
 * n 和 k 均为非负的整数。
 *
 * 示例:
 *
 * 输入: n = 3，k = 2
 * 输出: 6
 * 解析: 用 c1 表示颜色 1，c2 表示颜色 2，所有可能的涂色方案有:
 *
 *             柱 1    柱 2   柱 3
 *  -----      -----  -----  -----
 *    1         c1     c1     c2
 *    2         c1     c2     c1
 *    3         c1     c2     c2
 *    4         c2     c1     c1 
 *    5         c2     c1     c2
 *    6         c2     c2     c1
 *
 */
class Solution {
    /**
     * dp[i] 用来表示i个栅栏柱涂k种颜色色的方案数，有两种情况：
     * 如果：i与i-1的颜色相同，则表明i-1与i-2的颜色不同，则i的数目为dp[i-2]*(k-1)
     * 如果：i与i-1的颜色不同，则i的数目为dp[i-1]*(k-1)
     * 则递推公式为：
     * dp[i] = dp[i-2]*(k-1) + dp[i-1]*(k-1)
     *
     * @param n 栅栏柱个数
     * @param k 颜色数
     * @return 方案数
     */
    public int numWays(int n, int k) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i==0) {
                dp[i]=k;
            }else if (i==1){
                dp[i]=k*k;
            }else {
                dp[i] = dp[i - 2] * (k - 1) + dp[i - 1] * (k - 1);
            }
        }
        return n==0?0:dp[n - 1];
    }


    public static void main(String[] args) {
        System.out.println(new Solution().numWays(2, 46340));
    }
}