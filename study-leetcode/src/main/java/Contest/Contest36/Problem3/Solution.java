package Contest.Contest36.Problem3;

class Solution {
    int[][] directions=new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    public int minimumEffortPath(int[][] heights) {
        int row=heights.length,column=heights[0].length;
        int left=0,right=1000000;
        while (left<right) {
            int mid = left + ((right - left) >> 1);
            int[][] visited = new int[row][column];
            visited[0][0] = 1;
            dfs(heights, new int[]{0, 0}, mid, visited);
            if (visited[row - 1][column - 1] == 1) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private void dfs(int[][] heights,int[] current,int limit,int[][] visited){
        if (current[0]==heights.length-1 && current[1]==heights[0].length-1) {
            return;
        }
        for (int j = 0; j < directions.length; j++) {
            int[] next=new int[]{current[0]+directions[j][0],current[1]+directions[j][1]};
            //判断next是否可进入
            if (validPath(heights,next) && visited[next[0]][next[1]]==0) {
                int currentValue=heights[current[0]][current[1]];
                int nextValue=heights[next[0]][next[1]];
                int tempMax=Math.max(limit,Math.abs(currentValue-nextValue));
                if (tempMax<=limit){
                    visited[next[0]][next[1]]=1;
                    dfs(heights,next,limit,visited);
                }
            }
        }
    }
    private Boolean validPath(int[][] heights,int[] next){
        return next[0]>=0 && next[0]<heights.length && next[1]>=0 && next[1]<heights[0].length;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumEffortPath(new int[][]{{1,2,2},{3,8,2},{5,3,5}}));
        System.out.println(new Solution().minimumEffortPath(new int[][]{{1}}));
        System.out.println(new Solution().minimumEffortPath(new int[][]{{1, 2, 3}, {3, 8, 4}, {5, 3, 5}}));
        System.out.println(new Solution().minimumEffortPath(new int[][]{{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}}));
    }
}