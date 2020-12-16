package DynamicProgramming.石子游戏专题.P877;

import java.util.Arrays;

/**
 *
 * 输入：[5,3,4,5]
 * 输出：true
 * 解释：
 * 亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。
 * 假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
 * 如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。
 * 如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。
 * 这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。
 *
 * 状态转移方程
 * 如果当前是亚历克斯来选
 * dp[i][j]=Math.max(dp[i+1][j]+piles[i],dp[i][j-1]+piles[j])
 * 否则
 * dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1])
 */
class Solution {
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        int[][] dp=new int[n+1][n+1];
        for (int j = 2; j <= n; j++) {
            for (int i = j-1; i > 0; i--) {
                int len=i-j+1;
                if (len%2==0) {
                    dp[i][j]=Math.max(dp[i+1][j]+piles[i-1],dp[i][j-1]+piles[j-1]);
                }else {
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        int sum= Arrays.stream(piles).sum();
        return dp[1][n]>sum/2;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().stoneGame(new int[]{5, 3, 4, 5}));

    }
}