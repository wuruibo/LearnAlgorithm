package 剑指offer.连续数列;

class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp=new int[nums.length];
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i==0) {
                dp[i]=nums[i];
            }else {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
    public int maxSubArrayNoSpace(int[] nums) {
        int max=Integer.MIN_VALUE,preMax=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i==0) {
                preMax=nums[i];
            }else {
                preMax = Math.max(preMax + nums[i], nums[i]);
            }
            max=Math.max(max,preMax);
        }
        return max;
    }
}