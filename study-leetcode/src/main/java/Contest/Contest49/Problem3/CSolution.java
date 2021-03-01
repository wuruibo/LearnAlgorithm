package Contest.Contest49.Problem3;

/**
 * https://leetcode-cn.com/problems/maximum-score-from-performing-multiplication-operations/solution/dong-tai-gui-hua-er-wei-zhuang-tai-ding-slg21/
 * @author yeqiaozhu.
 * @date 3/1/21
 */
public class CSolution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length,m = multipliers.length;
        int[][] dp = new int[1000 + 5][1000 + 5];
        dp[0][0] = 0;
        for (int i = 1;i <= m;++i) {
            dp[i][0] = dp[i - 1][0] + nums[i - 1] * multipliers[i - 1];
        }
        for (int j = 1;j <= m;++j) {
            dp[0][j] = dp[0][j - 1] + nums[n - j] * multipliers[j - 1];
        }
        for (int i = 1;i <= m;++i){
            for (int j = 1;i + j <= m;++j){
                dp[i][j] = Math.max(dp[i - 1][j] + nums[i - 1] * multipliers[i + j - 1],dp[i][j - 1] + nums[n - j] * multipliers[i + j - 1]);
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0;i <= m;++i) {
            ans = Math.max(ans,dp[i][m - i]);
        }
        return ans;
    }
}
