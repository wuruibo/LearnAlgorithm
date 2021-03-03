package Array.P304;

import java.util.Arrays;
import java.util.stream.Collectors;

class NumMatrix {
    //preSum[row2][col2]-preSum[row1][col2]-preSum[row2][col1]+preSum[row1][col1]
    private int[][] preSum;
    public NumMatrix(int[][] matrix) {
        if (matrix.length==0){
            return;
        }
        //初始化前缀和
        int n=matrix.length,m=matrix[0].length;
        preSum=new int[n+1][m+1];
        //横向前缀和
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                preSum[i][j]=preSum[i][j-1]+matrix[i-1][j-1];
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                preSum[i][j]+=preSum[i-1][j];
            }
        }
        Arrays.stream(preSum).forEach(ints -> System.out.println(Arrays.stream(ints).boxed().collect(Collectors.toList())));
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2+1][col2+1]-preSum[row1][col2+1]-preSum[row2+1][col1]+preSum[row1][col1];
    }

    public static void main(String[] args) {
        System.out.println(new NumMatrix(new int[][]{{3, 0, 1, 4, 2},{5, 6, 3, 2, 1},{1, 2, 0, 1, 5},{4, 1, 0, 1, 7},{1, 0, 3, 0, 5}}).sumRegion(2, 1, 4, 3));
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */