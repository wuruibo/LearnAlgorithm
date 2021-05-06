package 力扣春季杯.Problem2;

/**
 * 输入：num = 4, Xpos = 1, Ypos = 2
 *
 * 输出：5
 */
class Solution {
    private int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
    private int size=0;
    public int orchestraLayout(int num, int xPos, int yPos) {
        this.size=num;
        return 0;
    }
    private void dfs(int x,int y,int value){
        for (int i = 0; i < directions.length; i++) {
            int nx=directions[i][0]+x;
            int ny=directions[i][1]+y;

        }
    }
}