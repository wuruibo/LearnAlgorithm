package BinarySearch.P53;

/**
 * 面试题53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 10000
 */
class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int sum=0,target= (n+1)*n/2;
        for (int num : nums) {
            sum+=num;
        }

        return target-sum;
    }

    public static void main(String[] args) {
        int[] nums={1};
        System.out.println(new Solution().missingNumber(nums));

        int[] nums1={0,1,2,3,4,5,6,7,9};
        System.out.println(new Solution().missingNumber(nums1));
    }
}