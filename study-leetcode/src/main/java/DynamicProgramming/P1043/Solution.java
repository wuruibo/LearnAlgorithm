package DynamicProgramming.P1043;

import java.util.Arrays;

class Solution {
    /**
     * dp[i][k] 表示0-i的子数组分成k份的最优解
     * dp[i][k] 等于dp[i-1][k-1],dp[i-2][k-1].....dp[k-1][k-1]最大值
     * @param arr
     * @param k
     * @return
     */
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[][] dp=new int[arr.length][k+1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j <= k; j++) {

                //开始计算
                for (int r = i-1; r >= 0; r--) {
                    dp[i][j]=Math.max(dp[i][j],dp[r][j-1]+getMax(arr,r,i)*(i-r));
                }
            }
        }
        return dp[arr.length-1][k];
    }
    private int getMax(int[] arr,int i,int j){
        return Arrays.stream(Arrays.copyOfRange(arr, i, j)).max().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));
    }
}