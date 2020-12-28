package DynamicProgramming.单串问题.最大子数组和.P53;

/**
 * 这道题也可以通过前缀和来解答
 *
 * 参考前缀和相关总结
 *
 */
class Solution {
    /**
     * 纯动态规划
     * @param nums
     * @return
     */
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

    /**
     * 滚动数组优化
     * @return
     */
    public int maxSubArrayUpdate(int[] nums){
        if (nums==null || nums.length==0) {
            return 0;
        }
        int last=nums[0],max=nums[0];
        for (int i = 1; i < nums.length; i++) {
            last=Math.max(last+nums[i],nums[i]);
            max=Math.max(last,max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] ints={1,3,-4,5};
        System.out.println(new Solution().maxSubArray(ints));
        System.out.println(new Solution().maxSubArrayUpdate(ints));
    }
}