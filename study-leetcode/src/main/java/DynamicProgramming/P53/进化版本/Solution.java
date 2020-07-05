package DynamicProgramming.P53.进化版本;

/**
 * 这道题也可以通过前缀和来解答
 *
 * 参考前缀和相关总结
 *
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        }
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int max=dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            max=Math.max(dp[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] ints={1,3,-4,5};
        System.out.println(new Solution().maxSubArray(ints));
    }
}