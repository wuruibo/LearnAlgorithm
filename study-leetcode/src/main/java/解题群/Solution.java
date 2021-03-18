package 解题群;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private int max=0;
    private int result=0;

    public int findCenter(int[][] edges) {
        Map<Integer,Integer> hash=new HashMap(12);
        for(int i=0;i<edges.length;i++){
            int[] temp=edges[i];

            hash.put(temp[0],hash.getOrDefault(temp[0],0)+1);
            hash.put(temp[1],hash.getOrDefault(temp[1],0)+1);

        }
        hash.forEach((key,value)->{
            if (value>max){
                max=Math.max(max,value);
                result=key;
            }
        });
        return result;
    }

    public static void main(String[] args) {
        System.out.println(-0.15*11.56+0.60*9.91-0.99*9.37+2.80*6.16+2.97*5.56+1.24*3.82+2.14*3.43+0.61*3.23+0.99*3.02+2.46*2.83);
        System.out.println(new Solution().findCenter(new int[][]{{1,2},{2,3},{4,2}}));
        System.out.println(new Solution().findCenter(new int[][]{{1,2},{5,1},{1,3},{1,4}}));
    }
}