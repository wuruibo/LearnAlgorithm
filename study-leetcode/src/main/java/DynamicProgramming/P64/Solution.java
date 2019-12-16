package DynamicProgramming.P64;

/**
 * solution using recursive
 */
class Solution {
    private int[][] grid;
    public int minPathSum(int[][] grid) {
        if(grid.length==0){
            return 0;
        }
        this.grid=grid;
        return recursive(grid.length,grid[0].length);
    }

    public int recursive(int m,int n){
        if(m==1){
            return sumN(m,n);
        } else if(n==1){
            return sumM(m,n);
        }else {
            return Math.min(recursive(m-1,n),recursive(m,n-1))+grid[m-1][n-1];
        }
    }
    public int sumM(int m,int n){
        int sum=0;
        for (int i = 0; i < m; i++) {
            sum+=grid[i][0];
        }
        return sum;
    }
    public int sumN(int m,int n){
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum+=grid[0][i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] ints={{1,3,1},{1,5,1},{4,2,1}};
        int[][] intsTest={{1,2,5},{3,2,1}};
        //System.out.println(new Solution().minPathSum(ints));
        System.out.println(new Solution().minPathSum(intsTest));
    }
}