package Contest.Contest26.Problem3;

/**
 * P1559 典型的深度优先搜索：
 *
 * 用一个visited二维数组来记录某个位置是否被访问过；
 * dfs方法中能否进入下一层递归的条件为 1. 下一个位置没有越界； 2. 下一个位置的字符和当前位置相同； 3，不要重复访问上一个位置（pre表示上一个位置，初始时为null, 则不需要判断这个条件）
 * dfs如果访问到visited为true的节点，则说明找到了环。
 *
 */
public class Solution {
    private boolean[][] visited;
    private char[][] grid;
    private int width;
    private int length;
    private int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean containsCycle(char[][] grid) {
        if(grid.length == 0) {
            return false;
        }
        this.grid = grid;
        this.length = grid.length;
        this.width = grid[0].length;
        this.visited = new boolean[length][width];
        for(int i = 0; i < length; i++){
            for(int j = 0; j < width; j++){
                if(!visited[i][j] && dfs(new int[]{i, j}, null)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int[] cur, int[] pre){
        if(visited[cur[0]][cur[1]]) {
            return true;
        }
        boolean result = false;
        visited[cur[0]][cur[1]] = true;
        char target = grid[cur[0]][cur[1]];
        for(int[] dir: directions){
            int nextX = dir[0] + cur[0], nextY = dir[1] + cur[1];
            if(nextX >= 0 && nextX < length && nextY >=0 && nextY < width && grid[nextX][nextY] == target && (pre != null ? (nextX != pre[0] || nextY != pre[1]) : true)){
                result = result || dfs(new int[]{nextX, nextY}, cur);
            }
            if(result) {
                break;
            }
        }
        return result;
    }
}
