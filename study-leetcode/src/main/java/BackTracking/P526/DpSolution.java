package BackTracking.P526;

import java.util.Arrays;

/**
 * 状态压缩DP(当状态是list这种可以用位运算的数值来表示)
 * @author yeqiaozhu
 *
 */
public class DpSolution {
    int[] memo;
    public int countArrangement(int N) {
        this.memo = new int[1<<(N+1)];
        Arrays.fill(memo, -1);
        return dp(N, N, 0);
    }

    /**
     * dp函数定义为：从1到k中，在有N个位置的情况下，能构造多少个优美排列，status记录哪些元素被选取
     * 例如：N=3，当k=2时，status有可能为100，001（0代表被选取，010是不满足题意的，因为3不能放在第2位）
     * @param N
     * @param k
     * @param status
     * @return
     */
    public int dp(int N, int k, int status) {
        if(k == 1) {
            return 1;
        }
        if(memo[status] != -1) {
            return memo[status];
        }

        int count = 0;
        //状态转移例子：dp(0000) = dp(0001) + dp(0100) + dp(1000)；（dp(0010)不满足优美排列，因为4不能放在第三位）
        for(int i = 1; i <= N; i++) {
            int cur = 1<<i;
            //仅当此数字没被选取时，我们才能将其作为状态进行转移
            if((status & cur) == 0) {
                if(check(i, k)) {
                    count += dp(N, k-1, status|cur);
                }
            }
        }

        memo[status] = count;
        return memo[status];
    }

    /**
     * 查看此数字是否满足优美排列要求
     * @param i
     * @param num
     * @return
     */
    public boolean check(int i, int num) {
        return num % i == 0 || i % num == 0;
    }
}
