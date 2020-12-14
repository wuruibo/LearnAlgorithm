package DynamicProgramming.LIS题型总结.P646;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入：[[1,2], [2,3], [3,4]]
 * 输出：2
 * 解释：最长的数对链是 [1,2] -> [3,4]
 */
class Solution {
    public int findLongestChain(int[][] pairs) {
        //dp[i]表示以pairs[i]为结尾的最长上升子序列的长度
        int[] dp=new int[pairs.length];
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        int max=1;
        Arrays.fill(dp,1);
        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1]<pairs[i][0]) {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    max=Math.max(max,dp[i]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        System.out.println(new Solution().findLongestChain(new int[][]{{3,4},{2,3},{1,2}}));
    }
}