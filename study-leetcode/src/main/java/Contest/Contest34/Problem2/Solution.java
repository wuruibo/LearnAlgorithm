package Contest.Contest34.Problem2;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        //直接暴力求解
        int[] result = new int[3];
        int max=0;
        Comparator<int[]> comparator=(r1,r2)-> r1[0]!=r2[0]?r1[0]-r2[0]:r1[1]-r2[1];

        for (int i = 0; i < towers.length; i++) {
            int tempMax=0;
            for (int j = 0; j < towers.length; j++) {
                //计算到当前节点的信号强度
                tempMax+=getRadius(towers[i],towers[j],radius);
            }
            if (tempMax>max) {
                result=towers[i];
                max=tempMax;
            }else if (tempMax==max){
                if (comparator.compare(towers[i],result)<0) {
                    max=tempMax;
                    result=towers[i];
                }
            }
        }
        return Arrays.copyOf(result,2);
    }
    private int getRadius(int[] r1,int[] r2,int radius){
        double distance=Math.sqrt((r1[0]-r2[0])*(r1[0]-r2[0])+(r1[1]-r2[1])*(r1[1]-r2[1]));
        return distance<=radius?(int)(r2[2]/(1+distance)):0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().bestCoordinate(new int[][]{{1, 2, 5}, {2, 1, 7}, {3, 1, 9}}, 2));
        System.out.println(new Solution().bestCoordinate(new int[][]{{23,11,21}}, 9));
        System.out.println(new Solution().bestCoordinate(new int[][]{{1,2,13},{2,1,7},{0,1,9}}, 2));
        System.out.println(new Solution().bestCoordinate(new int[][]{{2,1,9},{0,1,9}}, 2));
    }
}