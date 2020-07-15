package Contest.Contest9.Problem4;

/**
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 *
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 *
 * 返回一对观光景点能取得的最高分。
 *
 *
 *
 * 示例：
 *
 * 输入：[8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 *
 *
 * 提示：
 *
 * 2 <= A.length <= 50000
 * 1 <= A[i] <= 1000
 *
 *
 * 将观光组合的得分公式改为：( A[i] + i ) + ( A[j] - j )
 *
 * 对于到达第 j 个观光景点所能达到的最大得分，为前面的最大的 ( A[i] + i )加上当前的 ( A[j] - j )，即 max{A[i] + i} + ( A[j] - j )，其中 (i < j)
 *
 * 只要保存下 j 左边的 A[i] + i 的最大值，只需要遍历一遍即可。
 *
 *
 */
class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            for (int j = i+1; j < A.length; j++) {
                int temp=A[j]+A[i]+i-j;
                max=Math.max(temp,max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
    }
}