package Contest.Contest19.Problem1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isPathCrossing(String path) {
        int[] location=new int[2];
        Map<Character,int[]> hash= new HashMap<>();
        hash.put('N',new int[]{0,1});
        hash.put('S',new int[]{0,-1});
        hash.put('E',new int[]{1,0});
        hash.put('W',new int[]{-1,0});
        int[][] ways=new int[path.length()+1][2];
        ways[0]=location;
        for (int i = 0; i < path.length(); i++) {
            int[] current=hash.get(path.charAt(i));
            int[] newLocation= Arrays.copyOf(ways[i],current.length);
            newLocation[0]+=current[0];
            newLocation[1]+=current[1];
            //判断遍历是否已经走过位置
            for (int j = 0; j <=i; j++) {
                if (ways[j][0]==newLocation[0] && ways[j][1]==newLocation[1]) {
                    return true;
                }
            }
            ways[i+1]=newLocation;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPathCrossing("NES"));
        System.out.println(new Solution().isPathCrossing("NESWW"));
        System.out.println(new Solution().isPathCrossing("N"));
        System.out.println(new Solution().isPathCrossing("SS"));
    }
}