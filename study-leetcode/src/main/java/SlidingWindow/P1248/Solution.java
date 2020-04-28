package SlidingWindow.P1248;

import java.util.Date;

/**
 * Given an array of integers nums and an integer k. A subarray is called nice if there are k odd numbers on it.
 *
 * Return the number of nice sub-arrays.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2,1,1], k = 3
 * Output: 2
 * Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
 * Example 2:
 *
 * Input: nums = [2,4,6], k = 1
 * Output: 0
 * Explanation: There is no odd numbers in the array.
 * Example 3:
 *
 * Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * Output: 16
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 */
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int res = 0, cnt = 0, even = 0;
        int l = 0, r = 0;
        while (r < n) {
            if (cnt<k && (nums[r++]&1)==1) cnt++;
            if (cnt == k) {
                even = 1;
                while ((nums[l++]&1)==0) even++;
                cnt--;
            }
            res += even;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Date().toString());
        int[] nums={2,2,2,1,2,2,1,2,2,2};
        System.out.println(new Solution().numberOfSubarrays(nums, 2));
    }
}