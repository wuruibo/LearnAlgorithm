package Contest.Contest49.Problem3;

/**
 * 输入：nums = [-5,-3,-3,-2,7,1], multipliers = [-10,-5,3,4,6]
 * 输出：102
 * 解释：一种最优解决方案如下：
 * - 选择开头处的整数 -5 ，[-5,-3,-3,-2,7,1] ，得 -5 * -10 = 50 分，累加到分数中。
 * - 选择开头处的整数 -3 ，[-3,-3,-2,7,1] ，得 -3 * -5 = 15 分，累加到分数中。
 * - 选择开头处的整数 -3 ，[-3,-2,7,1] ，得 -3 * 3 = -9 分，累加到分数中。
 * - 选择末尾处的整数 1 ，[-2,7,1] ，得 1 * 4 = 4 分，累加到分数中。
 * - 选择末尾处的整数 7 ，[-2,7] ，得 7 * 6 = 42 分，累加到分数中。
 * 总分数为 50 + 15 - 9 + 4 + 42 = 102 。
 *
 * dp[i][j]=Math.max(dp[i+1][j]+nums[i-1]*multipliers[n-(j-i+1)],dp[i][j-1]+nums[j-1]*multipliers[n-(j-i+1)]);
 *
 * dp[1][2]=Math.max(dp[2][2]+nums[0]*multipliers[4],dp[1][1]+nums[1]*multipliers[4])=-18
 * dp[2][3]=Math.max(dp[3][3]+nums[1]*multipliers[4],dp[2][2]+nums[2]*multipliers[4])=-18
 * dp[1][3]=Math.max(dp[2][3]+nums[0]*multipliers[3],dp[1][2]+nums[2]*multipliers[3])=-18
 *   0   1   2   3   4   5
 * 0 0   0   0   0   0   0
 * 1     0  -18 -30
 * 2         0  -18
 * 3             0
 * 4                0
 * 5                   0
 *
 */
class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n=nums.length,m=multipliers.length;
        int[][] dp=new int[n+2][n+2];
        //初始化dp数组 当j-i==n-m时设置为0
        for (int j = 1; j <= n; j++) {
            for (int i = j-(n-m); i > 0; i--) {
                dp[i][j]= Math.max(dp[i+1][j]+nums[i-1]*multipliers[n-(j-i+1)],dp[i][j-1]+nums[j-1]*multipliers[n-(j-i+1)]);
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumScore(new int[]{-5, -3, -3, -2, 7, 1}, new int[]{-10, -5, 3, 4, 6}));
        System.out.println(new Solution().maximumScore(new int[]{1,2,3}, new int[]{3,2,1}));
    }
}