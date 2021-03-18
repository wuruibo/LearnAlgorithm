package Trie;

/**
 * 输入：nums = [1,4,3,7,4,5], k = 3
 * 输出：15
 * 解释：最优子数组的左右端点下标是 (1, 5) ，分数为 min(4,3,7,4,5) * (5-1+1) = 3 * 5 = 15 。
 *
 *
 * 输入：nums = [5,5,4,5,4,1,1,1], k = 0
 * 输出：20
 * 解释：最优子数组的左右端点下标是 (0, 4) ，分数为 min(5,5,4,5,4) * (4-0+1) = 4 * 5 = 20 。
 *
 *
 */
class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length, ans = 0;
        for (int i = nums[k], l = k, r = k; i >= 1; --i) {
            while (l > 0 && nums[l - 1] >= i) {
                --l;
            }
            while (r + 1 < n && nums[r + 1] >= i) {
                ++r;
            }
            ans = Math.max(ans, (r - l + 1) * i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumScore(new int[]{1, 4, 3, 7, 4, 5}, 3));
        System.out.println(new Solution().maximumScore(new int[]{5,5,4,5,4,1,1,1}, 0));
        System.out.println(new Solution().maximumScore(new int[]{6569,9667,3148,7698,1622,2194,793,9041,1670,1872}, 5));
    }
}