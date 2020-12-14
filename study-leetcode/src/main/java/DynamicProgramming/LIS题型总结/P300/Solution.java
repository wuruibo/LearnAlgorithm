package DynamicProgramming.LIS题型总结.P300;

import java.util.Arrays;

/**
 * https://lucifer.ren/blog/2020/06/20/LIS/
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        //dp[i] 表示以nums[i]为结尾的最大上升子序列长度
        int max=1;
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i]) {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    max=Math.max(dp[i],max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}