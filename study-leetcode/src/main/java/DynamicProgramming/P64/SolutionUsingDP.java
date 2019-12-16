package DynamicProgramming.P64;

/**
 * solution using dp+memo 循环+归档
 *
 * @autor yeqiaozhu.
 * @date 2019-09-02
 */
public class SolutionUsingDP {
    private int[][] mins;
    public int minPathSum(int[][] grid) {
        if(grid.length==0){
            return 0;
        }
        int m=grid.length;
        int n=grid[0].length;
        this.mins=new int[m][n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(i==0 && j==0){
                    mins[i][j]=grid[i][j];
                } else if(i==0 && j>0){
                    mins[i][j]=mins[i][j-1]+grid[i][j];
                } else if(j==0 && i>0){
                    mins[i][j]=mins[i-1][j]+grid[i][j];
                } else {
                    mins[i][j] = Math.min(mins[i - 1][j], mins[i][j - 1])+grid[i][j];
                }
            }
        }
        return mins[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] intsTest={{1,2,5},{3,2,1}};
        int[][] ints={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(new Solution().minPathSum(ints));
        System.out.println(new SolutionUsingDP().minPathSum(intsTest));
    }
}
