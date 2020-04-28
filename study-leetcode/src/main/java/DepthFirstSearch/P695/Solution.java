package DepthFirstSearch.P695;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 *
 * Example 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 *
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 * Note: The length of each dimension in the given grid does not exceed 50.
 */
class Solution {
    int[][] dirs={
            {-1,0},
            {0,1},
            {0,-1},
            {1,0}
    };
    int max=0;
    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==1) max=Math.max(dfs(grid,i,j),max);
            }
        }
        return max;
    }

    private int dfs(int[][] grid,int i,int j){
        grid[i][j]=0;
        int count=1;
        for (int[] dir : dirs) {
            int nx=dir[0]+i;
            int ny=dir[1]+j;
            if (inCircle(nx,ny,grid) && grid[nx][ny]==1) count+=dfs(grid,nx,ny);
        }
        return count;
    }
    private boolean inCircle(int m,int n,int[][] grid){
        return  !(m<0 || n>=grid[0].length || m>=grid.length || n<0);
    }

    public static void main(String[] args) {
        int[][] test=
       {{0,0,1,0,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,1,1,0,1,0,0,0,0,0,0,0,0},
        {0,1,0,0,1,1,0,0,1,0,1,0,0},
        {0,1,0,0,1,1,0,0,1,1,1,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(new Solution().maxAreaOfIsland(test));

        int[][] test1={{0,0,0,0,0,0,0,0}};
        System.out.println(new Solution().maxAreaOfIsland(test1));

        int[][] test2={{1,1,0,0,0},
                        {1,1,0,0,0},
                        {0,0,0,1,1},
                        {0,0,0,1,1}};
        System.out.println(new Solution().maxAreaOfIsland(test2));

    }
}