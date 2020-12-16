package DynamicProgramming.LIS题型总结.P673;

import java.util.Arrays;

/**
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 */
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length,number=0,max=1;
        int[] dp=new int[n];
        int[] count=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (nums[i]<nums[j]) {
                    if (dp[i] + 1>dp[j]) {
                        dp[j]=dp[i]+1;
                        count[j]=count[i];
                    }else if (dp[i] + 1==dp[j]){
                        count[j]+=count[i];
                    }
                }
            }
            max=Math.max(max,dp[j]);
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i]==max) {
                number+=count[i];
            }
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2}));
        System.out.println(new Solution().findNumberOfLIS(new int[]{1,3,5,4,7}));
        System.out.println(new Solution().findNumberOfLIS(new int[]{1,3,2}));
        System.out.println(new Solution().findNumberOfLIS(new int[]{1,1,1,1,1}));
    }
}