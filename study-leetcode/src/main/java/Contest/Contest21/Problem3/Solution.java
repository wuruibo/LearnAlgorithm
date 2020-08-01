package Contest.Contest21.Problem3;

/**
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 *
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 *
 * 如果不存在这样的子数组，请返回 0 。
 *
 *
 *
 * 提示 1：
 *
 * 输入：nums = [1,1,0,1]
 * 输出：3
 * 解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
 * 示例 2：
 *
 * 输入：nums = [0,1,1,1,0,1,1,0,1]
 * 输出：5
 * 解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
 * 示例 3：
 *
 * 输入：nums = [1,1,1]
 * 输出：2
 * 解释：你必须要删除一个元素。
 * 示例 4：
 *
 * 输入：nums = [1,1,0,0,1,1,1,0,1]
 * 输出：4
 * 示例 5：
 *
 * 输入：nums = [0,0,0]
 * 输出：0
 *
 * sliding window
 */
class Solution {
    public int longestSubarray(int[] nums) {
        int sum=0,left=0,res=0;
        for (int right = 0; right < nums.length; right++) {
            sum+=nums[right];
            //如果sum<right-left的话说明当前的窗口出现两个0 需要左边往右滑动
            while (right > left && sum < right - left) {
                sum-=nums[left];
                left++;
            }
            //0个或者一个0的窗口可以进入到这里
            res=Math.max(res,right-left);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestSubarray(new int[]{1,0,0,0,0}));
        System.out.println(new Solution().longestSubarray(new int[]{1,1,0,1}));
        System.out.println(new Solution().longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
        System.out.println(new Solution().longestSubarray(new int[]{1,1,1}));
        System.out.println(new Solution().longestSubarray(new int[]{1,1,0,0,1,1,1,0,1}));
        System.out.println(new Solution().longestSubarray(new int[]{0,0,0}));
    }
}