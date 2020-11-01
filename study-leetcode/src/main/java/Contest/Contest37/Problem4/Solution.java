package Contest.Contest37.Problem4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    private int[][] directions={{0,1},{1,0}};
    private String[] strings={"H","V"};
    private int[] destination;
    public String kthSmallestPath(int[] destination, int k) {
        this.destination=destination;
        List<String> result= new ArrayList<>();
        dfs(result,new int[]{0,0},new StringBuilder());
        Collections.sort(result);
        return result.get(k-1);
    }
    private void dfs(List<String> result,int[] pos,StringBuilder temp){
        if (pos[0]==destination[0] && pos[1]==destination[1]){
            result.add(new String(temp));
            return;
        }
        if (temp.length()>destination[0]+destination[1]) {
            return;
        }
        for (int i = 0; i < directions.length; i++) {
            int[] next={pos[0]+directions[i][0],pos[1]+directions[i][1]};
            if (valid(next)) {
                temp.append(strings[i]);
                dfs(result,next,temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
    private boolean valid(int[] next){
        int i=next[0],j=next[1];
        return i>=0 && i<=15 && j>=0 && j<=15;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().kthSmallestPath(new int[]{2, 3}, 1));
        System.out.println(new Solution().kthSmallestPath(new int[]{2, 3}, 2));
        System.out.println(new Solution().kthSmallestPath(new int[]{2, 3}, 3));
    }
}