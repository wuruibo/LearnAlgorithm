package DynamicProgramming.单串问题.最大子数组和.最大子矩阵;

/**
 * 输入：
 * [
 *    [-1,0],
 *    [0,-1]
 * ]
 * 输出：[0,1,0,1]
 * 解释：输入中标粗的元素即为输出所表示的矩阵
 *
 * https://leetcode-cn.com/problems/max-submatrix-lcci/solution/javadong-tai-gui-hua-de-si-lu-by-jie-dong/
 */
class Solution {
    public int[] getMaxMatrix(int[][] matrix) {
        //step1 先统计二纬前缀和 计算公式 preSum[i][j]=preSum[i-1][j]+preSum[i][j-1]-preSum[i-1][j-1]+matrix[i-1][j-1];
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] preSum=new int[m+1][n+1];
        for (int i = 1; i < preSum.length; i++) {
            for (int j = 1; j < preSum[i].length; j++) {
                preSum[i][j]=preSum[i-1][j]+preSum[i][j-1]-preSum[i-1][j-1]+matrix[i-1][j-1];
            }
        }
        //step2 任意选取两行 计算当前情况下的最大和 例如第1行和第1行可以构成的矩阵的最大和 然后计算第1行和第2行可以构成的矩阵的最大和 以此类推
        int max=Integer.MIN_VALUE;
        int[] result=new int[]{0,0,0,0};
        for (int i = 0; i < preSum.length; i++) {
            for (int j = i+1; j < preSum.length; j++) {
                int s=0;
                //计算的是 右下角[j,k] 左上角[i,start]
                //计算公式为 preSum[j][k]-preSum[j][s]-preSum[i][k]+preSum[i][s]
                for (int k = 1; k < preSum[i].length; k++) {
                    int cur=preSum[j][k]-preSum[j][s]-preSum[i][k]+preSum[i][s];
                    System.out.println(cur);
                    if (cur>max) {
                        max=cur;
                        //将结果集记录下来
                        result=new int[]{i,s,j-1,k-1};
                    }
                    if (cur<0){
                        s=k;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().getMaxMatrix(new int[][]{{9, -8, 1, 3, -2}, {-3, 7, 6, -2, 4}, {6, -4, -4, 8, -7}}));
        System.out.println(new Solution().getMaxMatrix(new int[][]{{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}}));
    }
}