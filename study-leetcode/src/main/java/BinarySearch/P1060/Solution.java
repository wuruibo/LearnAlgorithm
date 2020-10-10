package BinarySearch.P1060;

/**
 * 给出一个有序数组 A，数组中的每个数字都是 独一无二的，找出从数组最左边开始的第 K 个缺失数字。
 *
 * 示例 1：
 *
 * 输入：A = [4,7,9,10], K = 1
 * 输出：5
 * 解释：
 * 第一个缺失数字为 5 。
 * 示例 2：
 *
 * 输入：A = [4,7,9,10], K = 3
 * 输出：8
 * 解释：
 * 缺失数字有 [5,6,8,...]，因此第三个缺失数字为 8 。
 * 示例 3：
 *
 * 输入：A = [1,2,4], K = 3
 * 输出：6
 * 解释：
 * 缺失数字有 [3,5,6,7,...]，因此第三个缺失数字为 6 。
 *
 */
class Solution {
    int missing(int idx, int[] nums) {
        return nums[idx] - nums[0] - idx;
    }

    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        // If kth missing number is larger than
        // the last element of the array
        if (k > missing(n - 1, nums)) {
            return nums[n - 1] + k - missing(n - 1, nums);
        }

        int left = 0, right = n - 1, pivot;
        // find left = right index such that
        // missing(left - 1) < k <= missing(left)
        while (left != right) {
            pivot = left + (right - left) / 2;

            if (missing(pivot, nums) < k) {
                left = pivot + 1;
            } else {
                right = pivot;
            }
        }

        // kth missing number is larger than nums[idx - 1]
        // and smaller than nums[idx]
        return nums[left - 1] + k - missing(left - 1, nums);
    }
}
