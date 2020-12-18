package DynamicProgramming.石子游戏专题.P1690;

/**
 * 输入：stones = [5,3,1,4,2]
 * 输出：6
 * 解释：
 * - 爱丽丝移除 2 ，得分 5 + 3 + 1 + 4 = 13 。游戏情况：爱丽丝 = 13 ，鲍勃 = 0 ，石子 = [5,3,1,4] 。
 * - 鲍勃移除 5 ，得分 3 + 1 + 4 = 8 。游戏情况：爱丽丝 = 13 ，鲍勃 = 8 ，石子 = [3,1,4] 。
 * - 爱丽丝移除 3 ，得分 1 + 4 = 5 。游戏情况：爱丽丝 = 18 ，鲍勃 = 8 ，石子 = [1,4] 。
 * - 鲍勃移除 1 ，得分 4 。游戏情况：爱丽丝 = 18 ，鲍勃 = 12 ，石子 = [4] 。
 * - 爱丽丝移除 4 ，得分 0 。游戏情况：爱丽丝 = 18 ，鲍勃 = 12 ，石子 = [] 。
 * 得分的差值 18 - 12 = 6 。
 *
 * 将问题转换为求爱丽丝能够获取到的最大的石子
 *
 * 0 0 0 0 0 0
 * 0 0 -3 5 -4 9
 * 0 0 0 -1 4 -3
 * 0 0 0 0 -1 4
 * 0 0 0 0 0 -2
 * 0 0 0 0 0 0
 */
class Solution {
    public int stoneGameVII(int[] stones) {
        //先计算前缀和方便求区间和
        int n=stones.length;
        int[] preSum=new int[n+1];
        for (int i = 1; i <=n; i++) {
            preSum[i]=preSum[i-1]+stones[i-1];
        }
        //开始
        //开始区间dp dp[i][j]=Math.max(dp[i+1][j]+stones[i-1],dp[i][j-1]+stones[j-1])
        int[][] dp=new int[n+1][n+1];
        for (int j = 2; j <= n; j++) {
            for (int i = j-1; i > 0; i--) {
                int choose = (n - (j - i + 1)) % 2;

                //如果当前操作了偶数个 说明是alice选择 否则是另一个选
                if (choose== 0) {
                    dp[i][j] = Math.max(dp[i + 1][j] + preSum[j] - preSum[i], dp[i][j - 1] + preSum[j - 1] - preSum[i - 1]);
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j] - (preSum[j] - preSum[i]), dp[i][j - 1] - (preSum[j - 1] - preSum[i - 1]));
                }

            }
        }
        //Arrays.stream(dp).forEach(ints -> System.out.println(Arrays.stream(ints).boxed().map(Object::toString).reduce((a, b)->a+" "+b).get()));
        return dp[1][n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().stoneGameVII(new int[]{5,3,1,4,2}));
        System.out.println(new Solution().stoneGameVII(new int[]{7,90,5,1,100,10,10,2}));
        System.out.println(new Solution().stoneGameVII(new int[]{5}));
    }
}