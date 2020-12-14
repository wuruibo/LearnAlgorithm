package DynamicProgramming.LIS题型总结.P452;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
 *
 * 将问题转换为----->有多少个不重叠的区间----->递增的子序列的长度
 */
class Solution {
    public int findMinArrowShots(int[][] points) {
        int n=points.length;
        if (n==0) {
            return 0;
        }
        int[] dp=new int[points.length];
        Arrays.sort(points, Comparator.comparingInt(a->a[0]));
        Arrays.fill(dp,1);
        int max=1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (points[j][1]<points[i][0]) {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    max=Math.max(max,dp[i]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
    }
}