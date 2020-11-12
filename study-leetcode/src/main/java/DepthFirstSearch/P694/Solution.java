package DepthFirstSearch.P694;

import java.util.HashSet;
import java.util.Set;

/**
 * 示例 1：
 *
 * 11000
 * 11000
 * 00011
 * 00011
 * 给定上图，返回结果 1 。
 */
class Solution {
    private int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
    public int numDistinctIslands(int[][] grid) {
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        Set<String> set= new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==1 && !visited[i][j]) {
                    StringBuilder temp=new StringBuilder();
                    dfs(grid,temp,new int[]{i,j},visited,new int[]{i,j});
                    set.add(temp.toString());
                }
            }
        }
        return set.size();
    }
    private void dfs(int[][] grid,StringBuilder temp,int[] position,boolean[][] visited,int[] origin){
        visited[position[0]][position[1]]=true;
        temp.append(position[0]-origin[0]);
        temp.append(position[1]-origin[1]);
        for (int[] direction : directions) {
            int[] next=new int[]{position[0]+direction[0],position[1]+direction[1]};
            if (isValid(grid,next) && !visited[next[0]][next[1]]) {
                dfs(grid,temp,next,visited,origin);
            }
        }
    }
    private boolean isValid(int[][] grid,int[] position){
        return position[0]<grid.length && position[0]>=0 && position[1]<grid[0].length && position[1]>=0 && grid[position[0]][position[1]]==1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDistinctIslands(new int[][]{
                {0,0,1,0,1,0,1,1,1,0,0,0,0,1,0,0,1,0,0,1,1,1,0,1,1,1,0,0,0,1,1,0,1,1,0,1,0,1,0,1,0,0,0,0,0,1,1,1,1,0},
                {0,0,1,0,0,1,1,1,0,0,1,0,1,0,0,1,1,0,0,1,0,0,0,1,0,1,1,1,0,0,0,0,0,0,0,1,1,1,0,0,0,1,0,1,1,0,1,0,0,0},
                {0,1,0,1,0,1,1,1,0,0,1,1,0,0,0,0,1,0,1,0,1,1,1,0,1,1,1,0,0,0,1,0,1,0,1,0,0,0,1,1,1,1,1,0,0,1,0,0,1,0},
                {1,0,1,0,0,1,0,1,0,0,1,0,0,1,1,1,0,1,0,0,0,0,1,0,1,0,0,1,0,1,1,1,0,1,0,0,0,1,1,1,0,0,0,0,1,1,1,1,1,1}}));

        System.out.println(new Solution().numDistinctIslands(new int[][]{{1,1,0,1,1},
                {1,0,0,0,0},
                {0,0,0,0,1},
                {1,1,0,1,1}}));
    }
}