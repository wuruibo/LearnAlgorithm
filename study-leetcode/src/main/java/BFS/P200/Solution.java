package BFS.P200;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 宽度优先搜索利用队列
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
class Solution {
    public int numIslands(char[][] grid) {

        //保证入参的完整性
        if (grid==null || grid.length==0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<Location> queue = new LinkedList<>();
        int count = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    queue.offer(new Location(i,j));
                    visited[i][j] = true;
                    bfs(grid, queue, visited);
                    count++;
                }
            }
        }

        return count;
    }
    int[][] dirs = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
    private void bfs(char[][] grid, Queue<Location> queue, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;

        while(!queue.isEmpty()) {
            Location curr = queue.poll();
            for (int[] dir : dirs) {
                int x = curr.getRow() + dir[0];
                int y = curr.getColumn() + dir[1];

                if (x < 0 || x >= m || y < 0 || y >=n || visited[x][y] || grid[x][y] == '0')
                    continue;

                visited[x][y] = true;
                queue.offer(new Location(x,y));
            }
        }
    }
    public static class Location{
        private Integer row;
        private Integer column;

        public Location(Integer row, Integer column) {
            this.row = row;
            this.column = column;
        }

        public Integer getRow() {
            return row;
        }

        public void setRow(Integer row) {
            this.row = row;
        }

        public Integer getColumn() {
            return column;
        }

        public void setColumn(Integer column) {
            this.column = column;
        }
    }
}