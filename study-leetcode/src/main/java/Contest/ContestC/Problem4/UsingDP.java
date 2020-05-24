package Contest.ContestC.Problem4;

import java.util.Arrays;

/**
 * 给你两个数组 nums1 和 nums2 。
 *
 * 请你返回 nums1 和 nums2 中两个长度相同的 非空 子序列的最大点积。
 *
 * 数组的非空子序列是通过删除原数组中某些元素（可能一个也不删除）后剩余数字组成的序列，但不能改变数字间相对顺序。比方说，[2,3,5] 是 [1,2,3,4,5] 的一个子序列而 [1,5,3] 不是。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [2,1,-2,5], nums2 = [3,0,-6]
 * 输出：18
 * 解释：从 nums1 中得到子序列 [2,-2] ，从 nums2 中得到子序列 [3,-6] 。
 * 它们的点积为 (2*3 + (-2)*(-6)) = 18 。
 * 示例 2：
 *
 * 输入：nums1 = [3,-2], nums2 = [2,-6,7]
 * 输出：21
 * 解释：从 nums1 中得到子序列 [3] ，从 nums2 中得到子序列 [7] 。
 * 它们的点积为 (3*7) = 21 。
 * 示例 3：
 *
 * 输入：nums1 = [-1,-1], nums2 = [1,1]
 * 输出：-1
 * 解释：从 nums1 中得到子序列 [-1] ，从 nums2 中得到子序列 [1] 。
 * 它们的点积为 -1 。
 *  
 *
 * 提示：
 *
 * 1 <= nums1.length, nums2.length <= 500
 * -1000 <= nums1[i], nums2[i] <= 100
 *  
 *
 * 点积：
 *
 * 定义 a = [a1, a2,…, an] 和 b = [b1, b2,…, bn] 的点积为：
 *
 *
 *
 * 这里的 Σ 指示总和符号。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-dot-product-of-two-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class UsingDP {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for (int[] temp : dp) {
            Arrays.fill(temp, -1001);
        }
        dp[0][0] = nums1[0] * nums2[0];
        int res = dp[0][0];
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = Math.max(dp[0][i], Math.max(nums1[0] * nums2[i], dp[0][i - 1]));
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i][0], Math.max(nums2[0] * nums1[i], dp[i - 1][0]));
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.max(Math.max(dp[i - 1][j - 1] + nums1[i] * nums2[j], nums1[i] * nums2[j]), Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[nums1.length - 1][nums2.length - 1];
    }
}