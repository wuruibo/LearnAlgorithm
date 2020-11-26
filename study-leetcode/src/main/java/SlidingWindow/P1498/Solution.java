package SlidingWindow.P1498;

import java.util.Arrays;

class Solution {
    public int numSubseq(int[] nums, int target) {
        //双指针 首尾指针
        Arrays.sort(nums);
        int[] pow = new int[nums.length];
        pow[0]=1;
        for(int i=1;i<nums.length;i++){
            pow[i]=pow[i-1]*2%1000000007;
        }
        int left=0,right=nums.length-1;
        long result=0;
        while (left <= right) {
            if (nums[left]+nums[right] <= target) {
                result+=pow[right-left];
                left++;
            }else {
                right--;
            }
        }
        return (int)(result%1000000007);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSubseq(new int[]{3, 5, 6, 7}, 9));
        System.out.println(new Solution().numSubseq(new int[]{3,3,6,8}, 10));
        System.out.println(new Solution().numSubseq(new int[]{2,3,3,4,6,7}, 12));
        System.out.println(new Solution().numSubseq(new int[]{5,2,4,1,7,6,8}, 16));
        System.out.println(new Solution().numSubseq(new int[]{14,4,6,6,20,8,5,6,8,12,6,10,14,9,17,16,9,7,14,11,14,15,13,11,10,18,13,17,17,14,17,7,9,5,10,13,8,5,18,20,7,5,5,15,19,14}, 22));
    }
}