package DynamicProgramming.单串问题.最大子数组和.P363;

import java.util.TreeSet;

/**
 * 输入: matrix = [[1,0,1],[0,-2,3]], k = 2
 * 输出: 2
 * 解释: 矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
 */
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] preSum=new int[m+1][n+1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n+1; j++) {
                preSum[i][j]=preSum[i-1][j]+preSum[i][j-1]-preSum[i-1][j-1]+matrix[i-1][j-1];
            }
        }
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < m + 1; i++) {
            for (int j = i+1; j < m+1; j++) {
                TreeSet<Integer> tree = new TreeSet<>();
                for (int c = 0; c < n+1; c++) {
                    int right=preSum[j][c]-preSum[i][c];
                    Integer high=tree.ceiling(right-k);
                    if (high!=null){
                        max=Math.max(max,right-high);
                    }
                    tree.add(right);
                }
            }
        }
        return max==Integer.MIN_VALUE?-1:max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSumSubmatrix(new int[][]{{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}}, 8));
        //System.out.println(new Solution().maxSumSubmatrix(new int[][]{{1, 0, 1}, {0, -2, 3}}, 2));
        //System.out.println(new Solution().maxSumSubmatrix(new int[][]{{2,2,-1}},0));
    }
}