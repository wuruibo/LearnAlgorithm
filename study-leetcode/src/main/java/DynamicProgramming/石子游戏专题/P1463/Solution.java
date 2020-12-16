package DynamicProgramming.石子游戏专题.P1463;

/**
 * 输入：stoneValue = [6,2,3,4,5,5]
 * 输出：18
 * 解释：在第一轮中，Alice 将行划分为 [6，2，3]，[4，5，5] 。左行的值是 11 ，右行的值是 14 。Bob 丢弃了右行，Alice 的分数现在是 11 。
 * 在第二轮中，Alice 将行分成 [6]，[2，3] 。这一次 Bob 扔掉了左行，Alice 的分数变成了 16（11 + 5）。
 * 最后一轮 Alice 只能将行分成 [2]，[3] 。Bob 扔掉右行，Alice 的分数现在是 18（16 + 2）。游戏结束，因为这行只剩下一块石头了。
 *
 * dp[i][j]表示区间下Alice能获得的最大的分数
 *
 * s
 */
class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n=stoneValue.length;
        int[] preSum=new int[n+1];
        for (int i = 1; i < stoneValue.length; i++) {
            preSum[i]=preSum[i-1]+stoneValue[i-1];
        }
        return 0;
    }
}