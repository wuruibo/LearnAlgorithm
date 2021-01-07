package Heap.P871;

import java.util.PriorityQueue;

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel>=target) {
            return 0;
        }
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>((a,b)->b-a);
        int count = 0;
        for(int i = 0;i<stations.length;i++){
            while(startFuel<stations[i][0]){//无法到达当前加油站时，从优先队列中取油
                if(priorityQueue.isEmpty()){//队列为空仍然无法到达，说明该加油站不可达。
                    return -1;
                }else{
                    startFuel+=priorityQueue.poll();
                    count++;
                }
            }
            priorityQueue.offer(stations[i][1]);
        }
        //注意遍历完加油站还要判断能不能到target
        while(startFuel<target){
            if(priorityQueue.isEmpty()){
                return -1;
            }else{
                startFuel+=priorityQueue.poll();
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String desc="贝亲韵达-菜鸟报错：1个订单([29_11344051_50982527])该区域物流公司总部设置为停发，超出物流商服务范围，请联系物流承运商;[29_11344051_50982527]物流服务不支持派送";
        //取最新的
        String[] descArray=desc.split("；");
        desc=descArray[0];
        System.out.println(desc.contains("停发"));
        System.out.println(new Solution().minRefuelStops(100, 10, new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}}));
        System.out.println(new Solution().minRefuelStops(999, 1000, new int[][]{{5,100},{997,100},{998,100}}));
        System.out.println(new Solution().minRefuelStops(100, 1, new int[][]{}));
        System.out.println(new Solution().minRefuelStops(10, 10, new int[][]{{}}));
        System.out.println(new Solution().minRefuelStops(1000, 299,new int[][]{{13,21},{26,115},{100,47},{225,99},{299,141},{444,198},{608,190},{636,157},{647,255},{841,123}}));
    }
}