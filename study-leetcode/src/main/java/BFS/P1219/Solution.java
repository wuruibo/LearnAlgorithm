package BFS.P1219;

import java.util.LinkedList;
import java.util.Queue;

/**
 * In a gold mine grid of size m * n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.
 *
 * Return the maximum amount of gold you can collect under the conditions:
 *
 * Every time you are located in a cell you will collect all the gold in that cell.
 * From your position you can walk one step to the left, right, up or down.
 * You can't visit the same cell more than once.
 * Never visit a cell with 0 gold.
 * You can start and stop collecting gold from any position in the grid that has some gold.
 *
 *
 * Example 1:
 *
 * Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
 * Output: 24
 * Explanation:
 * [[0,6,0],
 *  [5,8,7],
 *  [0,9,0]]
 * Path to get the maximum gold, 9 -> 8 -> 7.
 * Example 2:
 *
 * Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
 * Output: 28
 * Explanation:
 * [[1,0,7],
 *  [2,0,6],
 *  [3,4,5],
 *  [0,3,0],
 *  [9,0,20]]
 * Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
 *
 *
 * Constraints:
 *
 * 1 <= grid.length, grid[i].length <= 15
 * 0 <= grid[i][j] <= 100
 * There are at most 25 cells containing gold.
 */
class Solution {
    private static final int[] d = {0, 1, 0, -1, 0};
    public int getMaximumGold(int[][] grid) {
        int ans = 0, m = grid.length, n = grid[0].length;
        int[][] oneCellTrace = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0, goldCellId = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > 0) {
                    oneCellTrace[i][j] = 1 << goldCellId++;
                    q.offer(new int[]{i, j, grid[i][j], oneCellTrace[i][j]});
                }
            }
        }
        while (!q.isEmpty()) {
            int i = q.peek()[0], j = q.peek()[1], sum = q.peek()[2], trace = q.poll()[3];
            ans = Math.max(sum, ans);
            for (int k = 0; k < 4; ++k) {
                int r = i + d[k], c = j + d[k + 1];
                if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] > 0 && (trace & oneCellTrace[r][c]) == 0) {
                    q.offer(new int[]{r, c, sum + grid[r][c], trace | oneCellTrace[r][c]});
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] test={{1,0,7,0,0,0},
                      {2,0,6,0,1,0},
                      {3,5,6,7,4,2},
                      {4,3,1,0,2,0},
                      {3,0,5,0,20,0}};
        System.out.println(new Solution().getMaximumGold(test));

        int[][] test1={{0,6,0},{5,8,7},{0,9,0}};
        System.out.println(new Solution().getMaximumGold(test1));

        int[][] test2={{0,6,0},{5,8,7},{0,9,0}};
        System.out.println(new Solution().getMaximumGold(test2));
    }
}