
package DynamicProgramming.P213;

/**
 * 这种方式的时间复杂度是n2 空间复杂度n2
 *
 * dp[i][j]从i到j子串的最优解
 * 如果i为起始位置,j为数值结尾需要特殊处理
 * dp[0][nums.length-1]=max(dp[0][nums.length-1-1],dp[1][nums.length-1-2]+nums[nums.length-1])
 * 排除特殊情况其他情况
 * dp[i][j]=max(dp[i][j-1],dp[i][j-2])
 *
 * 边界值处理 dp[i][i]=nums[i]
 * dp[i][i+1]=max(nums[i],nums[i+1])
 */
class Solution {
    public int rob(int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        }
        //初始化
        int n=nums.length;
        int[][] dp=new int[n][n];
        //初始化边界值
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                if (i==0) {
                    dp[j][j+i]=nums[j];
                }else if(i==1){
                    dp[j][j+i]=Math.max(nums[j],nums[j+1]);
                }else if (i==n-1 && j==0){//特殊情况
                    dp[0][n-1]=Math.max(dp[0][n-2],dp[1][n-3]+nums[n-1]);
                }else {
                    dp[j][j+i]=Math.max(dp[j][j+i-1],dp[j][j+i-2]+nums[j+i]);
                }
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        System.out.println(new Solution().rob(nums));

        int[] nums1={2,3,2};
        System.out.println(new Solution().rob(nums1));
    }
}