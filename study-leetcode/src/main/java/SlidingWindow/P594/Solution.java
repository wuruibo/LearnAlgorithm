package SlidingWindow.P594;

import java.util.Arrays;

class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int max=0;
        for (int end = 0,begin=0; end < nums.length; end++) {
            while (nums[end] - nums[begin] > 1) {
                begin++;
            }
            if (nums[end]-nums[begin]==1) {
                max=Math.max(max,end-begin+1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
    }
}