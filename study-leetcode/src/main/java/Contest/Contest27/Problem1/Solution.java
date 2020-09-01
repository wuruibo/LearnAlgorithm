package Contest.Contest27.Problem1;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] visitedTime=new int[n];
        for (int i = 0; i < rounds.length-1; i++) {
            if (i==0) {
                visitedTime[rounds[0]-1]++;
            }
            visitCircle(visitedTime,n,rounds[i],rounds[i+1]);
        }
        //最大
        int max=0;
        for (int i : visitedTime) {
            max=Math.max(i,max);
        }
        List<Integer> result= new ArrayList<>();
        for (int i = 0; i < visitedTime.length; i++) {
            if (visitedTime[i]==max) {
                result.add(i+1);
            }
        }
        return result;
    }
    private void visitCircle(int[] visitedTime,int n,int start,int end){
        while (start!=end){
            start++;
            if (start==n+1) {
                start=1;
            }
            visitedTime[start-1]++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mostVisited(4, new int[]{1, 3, 1, 2}));
        System.out.println(new Solution().mostVisited(2, new int[]{2,1,2,1,2,1,2,1,2}));
        System.out.println(new Solution().mostVisited(7, new int[]{1,3,5,7}));
    }
}