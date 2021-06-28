package 剑指offer.顺时针遍历矩阵;

class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0){
            return new int[]{};
        }
        //规则 右->下->左->上规则
        int left=0,right=matrix[0].length-1,top=0,bottom=matrix.length-1;
        int[] res=new int[matrix.length*matrix[0].length];
        int cnt=0;
        while(left<=right){
            //从左往右打印
            for (int j = left; j <= right && cnt<res.length; j++) {
                res[cnt++]=matrix[top][j];
            }
            top++;
            //从上往下打印
            for (int i = top; i <= bottom && cnt<res.length; i++) {
                res[cnt++]=matrix[i][right];
            }
            right--;
            //从右往左打印
            for (int j = right; j >= left && cnt<res.length; j--) {
                res[cnt++]=matrix[bottom][j];
            }
            bottom--;
            //从下往上打印
            for (int i = bottom; i >=top && cnt<res.length; i--) {
                res[cnt++]=matrix[i][left];
            }
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] params=new int[]{1,1,1};
        System.out.println(new Solution().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }
}