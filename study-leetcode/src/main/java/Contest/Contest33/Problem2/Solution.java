package Contest.Contest33.Problem2;

import java.util.Arrays;

/**
 * 300：最长上升子序列，不连续
 * 此题：既然上升优先，但前提又不能年龄大的反而分数小，那就先 优先按照年龄 排序
 * 比如 scores = [1,2,3,5], ages = [8,9,10,1],合起来就是[[8,1][9,2][10,3][1,5]]
 * 1. 排序 ：[[1,5][8,1][9,2][10,3]]
 * 2. 最长上升子序列：按照第二列，此时成绩，已经保证后的年龄>前的，且同一年龄的是成绩升序
 */
class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int len = scores.length;

        int[][] combine = new int[len][2];
        for(int i = 0; i < len; i++){
            combine[i][0] = ages[i];
            combine[i][1] = scores[i];
        }

        Arrays.sort(combine, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);

        int[] dp = new int[len];
        int ans = 0;
        for(int i = 0; i < len; i++){
            dp[i] = combine[i][1];
            for(int j = 0; j < i; j++){
                if(combine[j][1] <= combine[i][1]){
                    dp[i] = Math.max(dp[i], combine[i][1] + dp[j]);
                }
            }
        }

        for(int i = 0; i < len; i++){
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}