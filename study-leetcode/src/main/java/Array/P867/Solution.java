package Array.P867;

class Solution {
    public int[][] transpose(int[][] A) {
        int row=A[0].length;
        int col=A.length;
        int[][] result=new int[row][col];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j]=A[j][i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().transpose(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println(new Solution().transpose(new int[][]{{1,2,3},{4,5,6}}));
    }
}