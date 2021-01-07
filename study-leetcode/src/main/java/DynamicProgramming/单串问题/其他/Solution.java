package DynamicProgramming.单串问题.其他;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 输入：target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
 * 输出：2
 * 解释：
 * 我们出发时有 10 升燃料。
 * 我们开车来到距起点 10 英里处的加油站，消耗 10 升燃料。将汽油从 0 升加到 60 升。
 * 然后，我们从 10 英里处的加油站开到 60 英里处的加油站（消耗 50 升燃料），
 * 并将汽油从 10 升加到 50 升。然后我们开车抵达目的地。
 * 我们沿途在1两个加油站停靠，所以返回 2 。
 */
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (stations.length==0) {
            return target<startFuel?-1:0;
        }
        //定义dp问题
        List<int[]> stationList=Arrays.stream(stations)
                .sorted(Comparator.comparingInt(ints->ints[0]))
                .collect(Collectors.toList());
        stationList.add(0,new int[]{0,startFuel});
        stationList.add(new int[]{target,0});
        int n=stationList.size();
        int[][] dp=new int[n][2];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0]=target;
        }
        dp[0]=new int[]{0,startFuel};
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                //dp[i] 取最小的dp[i][0] 同时取最大的dp[i][1] 在能够到达的前提下
                int need=stationList.get(i)[0]-stationList.get(j)[0];
                if (need<=dp[j][1]) {
                   int[] next=new int[]{dp[j][0]+1,dp[j][1]-need+stationList.get(i)[1]};
                   Comparator<int[]> comparator=(l,r)->l[0]==r[0]?r[1]-l[1]:l[0]-r[0];
                   if (comparator.compare(dp[i],next)>0){
                       dp[i]=next;
                   }
                }
            }
        }
        return dp[n-1][0]==target?-1:dp[n-1][0]-1;
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().minRefuelStops(100, 10, new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}}));
        //System.out.println(new Solution().minRefuelStops(100, 1, new int[][]{{10,100}}));
        //System.out.println(new Solution().minRefuelStops(10, 10, new int[][]{{10,100}}));
        System.out.println(new Solution().minRefuelStops(1000, 299,new int[][]{{13,21},{26,115},{100,47},{225,99},{299,141},{444,198},{608,190},{636,157},{647,255},{841,123}}));
    }
}