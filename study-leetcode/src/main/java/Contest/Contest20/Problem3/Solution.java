package Contest.Contest20.Problem3;

import java.util.Arrays;

/**
 *
 * 要求 [最大值 - 最小值] 的最小值
 * 有 3 次修改数字的机会
 * 假如只有 1 次机会，想要答案最小，要么修改最大值，要么修改最小值
 * 1. 其实修改成什么不重要，只要修改完之后不再是最大值或是最小值就好
 * 2. 所以跟删了是一个意思
 * 如果有 3 次机会，那么就是以下几种可能
 * 1. 删除 3 个最大值
 * 2. 删除 1 个最小值，删除 2 个最大值
 * 3. 删除 2 个最小值，删除 1 个最大值
 * 4. 删除 3 个最小值
 * 如果删除 3 个数之后，还剩 1 个数，那么答案也是 0 ，所以开始的时候，数组小于 4 都没必要计算
 * 所以排个序解决
 *
 */
class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 4) {
            return 0;
        }

        Arrays.sort(nums);
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            ret = Math.min(ret, nums[n - 4 + i] - nums[i]);
        }
        return ret;
    }
}
