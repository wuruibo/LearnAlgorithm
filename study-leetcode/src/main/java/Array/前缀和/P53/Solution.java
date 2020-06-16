package Array.前缀和.P53;

/**
 * 面试题42. 连续子数组的最大和
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 */
class Solution {
    public int maxSubArray(int[] nums) {
        //前缀和数组
        int[] preSum=new int[nums.length+1];
        int tempSum=0,tempMin=0,max=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            preSum[i+1]=(tempSum+=nums[i]);
            //记录当前位置的最小值
            tempMin=Math.min(tempMin,preSum[i]);
            max=Math.max(max,preSum[i+1]-tempMin);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] test={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Solution().maxSubArray(test));

        int[] test1={-1};
        System.out.println(new Solution().maxSubArray(test1));
    }
}