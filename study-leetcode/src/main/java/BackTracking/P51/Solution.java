package BackTracking.P51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    private int[][] directions={{1,1},{1,-1},{-1,1},{-1,-1},{0,-1},{-1,0},{1,0},{0,1}};
    private List<List<String>> result=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        String[][] temp=new String[n][n];
        Arrays.stream(temp).forEach(ints->Arrays.fill(ints,"."));
        dfs(temp,n,0);
        return result;
    }
    private void dfs(String[][] temp,int n,int row){
        //n为0时候满足条件 可以收集结果
        if (n==0) {
            List<String> list= Arrays.stream(temp)
                    .map(ints-> Arrays.stream(ints)
                            .map(s->s.equals("-1")?".":s)
                            .reduce((s, s2) -> s+s2).get())
                    .collect(Collectors.toList());
            result.add(list);
            return;
        }
        int length=temp.length;

        for (int col = 0; col < length; col++) {
            if (temp[row][col].equals(".")) {
                //标记一下对角线 横线和竖线的位置为不可用 还是新构造一个吧
                String[][] next=Arrays.stream(temp)
                        .map(strings-> Arrays.stream(strings)
                                .toArray(i->new String[i]))
                        .toArray(i->new String[i][i]);
                //八个方向进行填充
                int x=row,y=col;
                for (int i = 0; i < directions.length; i++) {
                    while (x>=0 && x<temp.length && y>=0 && y<temp.length){
                        next[x][y]=".".equals(next[x][y])?"-1":next[x][y];
                        x+=directions[i][0];
                        y+=directions[i][1];
                    }
                    x=row;y=col;
                }
                next[row][col]="Q";
                //收集到一个 继续往下收集
                dfs(next,n-1,row+1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(9));
        System.out.println(new Solution().solveNQueens(4));
        System.out.println(new Solution().solveNQueens(2));
        System.out.println(new Solution().solveNQueens(1));
    }
}