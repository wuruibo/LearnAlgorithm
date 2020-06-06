package DepthFirstSearch.P1391;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Given a m x n grid. Each cell of the grid represents a street. The street of grid[i][j] can be:
 * 1 which means a street connecting the left cell and the right cell.
 * 2 which means a street connecting the upper cell and the lower cell.
 * 3 which means a street connecting the left cell and the lower cell.
 * 4 which means a street connecting the right cell and the lower cell.
 * 5 which means a street connecting the left cell and the upper cell.
 * 6 which means a street connecting the right cell and the upper cell.
 *
 *
 * You will initially start at the street of the upper-left cell (0,0). A valid path in the grid is a path which starts from the upper left cell (0,0) and ends at the bottom-right cell (m - 1, n - 1). The path should only follow the streets.
 *
 * Notice that you are not allowed to change any street.
 *
 * Return true if there is a valid path in the grid or false otherwise.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[2,4,3],[6,5,2]]
 * Output: true
 * Explanation: As shown you can start at cell (0, 0) and visit all the cells of the grid to reach (m - 1, n - 1).
 * Example 2:
 *
 *
 * Input: grid = [[1,2,1],[1,2,1]]
 * Output: false
 * Explanation: As shown you the street at cell (0, 0) is not connected with any street of any other cell and you will get stuck at cell (0, 0)
 * Example 3:
 *
 * Input: grid = [[1,1,2]]
 * Output: false
 * Explanation: You will get stuck at cell (0, 1) and you cannot reach cell (0, 2).
 * Example 4:
 *
 * Input: grid = [[1,1,1,1,1,1,3]]
 * Output: true
 * Example 5:
 *
 * Input: grid = [[2],[2],[2],[2],[2],[2],[6]]
 * Output: true
 */
class Solution {
    public boolean hasValidPath(int[][] grid) {
        return dfs(grid,0,0);
    }
    private boolean dfs(int[][] grid,int i,int j){
        if ((i==grid.length-1 && j==grid[0].length-1)) {
            return true;
        }
        int target=grid[i][j];
        grid[i][j]=-1;
        //如果当前值是1的话只能往左或往右走
        if (target==1) {
            //往左走
            if (isInArray(i,j-1,grid) && (grid[i][j-1]==1 || grid[i][j-1]==4 || grid[i][j-1]==6) && dfs(grid,i,j-1)) {
                return true;
            }
            //往右走
            if (isInArray(i,j+1,grid) && (grid[i][j+1]==1 || grid[i][j+1]==3 || grid[i][j+1]==5) && dfs(grid,i,j+1)) {
                return true;
            }
        }
        //如果当前值是2的话只能往下或者往上走
        if (target==2) {
            //往上走
            if (isInArray(i-1,j,grid) && (grid[i-1][j]==2 || grid[i-1][j]==3 || grid[i-1][j]==4) && dfs(grid,i-1,j)) {
                return true;
            }
            //往下走
            if (isInArray(i+1,j,grid) && (grid[i+1][j]==2 || grid[i+1][j]==5 || grid[i+1][j]==6) && dfs(grid,i+1,j)) {
                return true;
            }
        }
        if (target==3) {
            //往左走
            if (isInArray(i,j-1,grid) && (grid[i][j-1]==1 || grid[i][j-1]==4 || grid[i][j-1]==6) && dfs(grid,i,j-1)) {
                return true;
            }
            //往下走
            if (isInArray(i+1,j,grid) && (grid[i+1][j]==2 || grid[i+1][j]==5 || grid[i+1][j]==6) && dfs(grid,i+1,j)) {
                return true;
            }
        }
        if (target==4) {
            //往右走
            if (isInArray(i,j+1,grid) && (grid[i][j+1]==1 || grid[i][j+1]==3 || grid[i][j+1]==5) && dfs(grid,i,j+1)) {
                return true;
            }
            //往下走
            if (isInArray(i+1,j,grid) && (grid[i+1][j]==2 || grid[i+1][j]==5 || grid[i+1][j]==6) && dfs(grid,i+1,j)) {
                return true;
            }
        }
        if (target==5) {
            //往左走
            if (isInArray(i,j-1,grid) && (grid[i][j-1]==1 || grid[i][j-1]==4 || grid[i][j-1]==6) && dfs(grid,i,j-1)) {
                return true;
            }
            //往上走
            if (isInArray(i-1,j,grid) && (grid[i-1][j]==2 || grid[i-1][j]==3 || grid[i-1][j]==4) && dfs(grid,i-1,j)) {
                return true;
            }
        }
        if (target==6) {
            //往右走
            if (isInArray(i,j+1,grid) && (grid[i][j+1]==1 || grid[i][j+1]==3 || grid[i][j+1]==5) && dfs(grid,i,j+1)) {
                return true;
            }
            //往上走
            if (isInArray(i-1,j,grid) && (grid[i-1][j]==2 || grid[i-1][j]==3 || grid[i-1][j]==4) && dfs(grid,i+1,j)) {
                return true;
            }
        }
        return false;
    }
    boolean isInArray(int i,int j,int[][] grid){
        if (i<0 || i>=grid.length || j<0 || j>=grid[0].length) return false;
        return true;
    }
    private boolean dfsDirector(int[][] grid,int i,int j,char dir){
        if (dir=='L') {
            //往左走
            if (isInArray(i,j-1,grid) && (grid[i][j-1]==1 || grid[i][j-1]==4 || grid[i][j-1]==6)) {
                return dfs(grid,i,j-1);
            }
        }
        if (dir=='R') {
            //往右走
            if (isInArray(i,j+1,grid) && (grid[i][j+1]==1 || grid[i][j+1]==3 || grid[i][j+1]==5)) {
                return dfs(grid,i,j+1);
            }
        }
        if (dir=='T') {
            //往上走
            if (isInArray(i-1,j,grid) && (grid[i-1][j]==2 || grid[i-1][j]==3 || grid[i-1][j]==4)) {
                return dfs(grid,i+1,j);
            }
        }
        if (dir=='B') {
            //往上走
            if (isInArray(i-1,j,grid) && (grid[i-1][j]==2 || grid[i-1][j]==3 || grid[i-1][j]==4)) {
                return dfs(grid,i+1,j);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] test={{4,1},{6,1}};
        System.out.println(new Solution().hasValidPath(test));

        int[][] test1={{1,2,1},{1,2,1}};
        System.out.println(new Solution().hasValidPath(test1));

        int[][] test2= {{1,1,1,1,1,1,3}};
        System.out.println(new Solution().hasValidPath(test2));

        int[][] test3= {{2},{2},{2},{2},{2},{2},{6}};
        System.out.println(new Solution().hasValidPath(test3));
    }
}