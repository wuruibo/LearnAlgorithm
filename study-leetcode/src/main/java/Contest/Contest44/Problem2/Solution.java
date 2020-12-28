package Contest.Contest44.Problem2;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
 *
 * 返回 只删除一个 子数组可获得的 最大得分 。
 *
 * 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
 *
 * 输入：nums = [4,2,4,5,6]
 * 输出：17
 * 解释：最优子数组是 [2,4,5,6]
 */
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        //滑动窗口
        Set<Integer> set= new HashSet<>();
        int temp=0,max=Integer.MIN_VALUE;
        for (int i = 0,j=0; j < nums.length; j++) {
            while (!set.add(nums[j])) {
                temp-=nums[i];
                set.remove(nums[i++]);
            }
            //符合条件的子串的和
            temp+=nums[j];
            max=Math.max(max,temp);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6}));
        System.out.println(new Solution().maximumUniqueSubarray(new int[]{4}));
        System.out.println(new Solution().maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));
    }
}