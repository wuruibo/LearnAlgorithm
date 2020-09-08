package Contest.Contest28.Problem1;

class Solution {
    public int diagonalSum(int[][] mat) {
        int sum=0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if ((i==j) || (i+j+1==mat[i].length)){
                    sum+=mat[i][j];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(false^false);
        System.out.println(false^true);
        System.out.println(true^true);
        System.out.println(true^false);
        System.out.println(new Solution().diagonalSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(new Solution().diagonalSum(new int[][]{{1, 1, 1,1}, {1, 1, 1,1}, {1, 1, 1,1},{1, 1, 1,1}}));
    }
}