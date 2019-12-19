package TwoPointer.P16;

import java.util.Arrays;

/**
 * Example:
 *
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //第一步排序
        Arrays.sort(nums);

        //第二步循环 定义result
        int result=0,tempMax=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            //计算剩余目标值
            int last=target-nums[i];
            //定义双指针
            int left=i+1,right=nums.length-1;
            //双指针循环 第一种情况 nums[left]+nums[right]<target left++
            //第二种情况 nums[left]+nums[right]>target right--;
            while (left<right){
                int temp=nums[left]+nums[right];
                //更新result
                if (Math.abs(temp+nums[i]-target)<tempMax) {
                    result=temp+nums[i];
                    tempMax=Math.abs(temp+nums[i]-target);
                }
                //移动下标 三种情况移动
                if (temp>last) {
                    right--;
                }else if (temp<last){
                    left++;
                }else {
                    return target;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints={-1, 2, 1, -4};
        System.out.println(new Solution().threeSumClosest(ints,1));
    }
}