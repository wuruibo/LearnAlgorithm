package TwoPointer.P128;

import java.util.Arrays;

/**
 * using sort+double click
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        }
        Arrays.sort(nums);
        int end=1;
        //定义最大值
        int max=1,tempMax=1;
        while (end<nums.length){
            if (nums[end]==nums[end-1]) {
                //do nothing
            }else if (nums[end]-nums[end-1]==1) {
                tempMax++;
            }else {
                tempMax=1;
            }
            max=Math.max(max,tempMax);
            end++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] ints={100, 4, 200, 1, 3, 2};
        System.out.println(new Solution().longestConsecutive(ints));
        int[] ints1={100};
        System.out.println(new Solution().longestConsecutive(ints1));

        int[] ints2={1,2,0,1};
        System.out.println(new Solution().longestConsecutive(ints2));

    }
}