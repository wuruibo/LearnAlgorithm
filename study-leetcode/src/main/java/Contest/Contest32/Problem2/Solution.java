package Contest.Contest32.Problem2;

import java.util.Arrays;

/**
 * 输入：customers = [8,3], boardingCost = 5, runningCost = 6
 * 输出：3
 * 解释：座舱上标注的数字是该座舱的当前游客数。
 * 1. 8 位游客抵达，4 位登舱，4 位等待下一舱，摩天轮轮转。当前利润为 4 * $5 - 1 * $6 = $14 。
 * 2. 3 位游客抵达，4 位在等待的游客登舱，其他 3 位等待，摩天轮轮转。当前利润为 8 * $5 - 2 * $6 = $28 。
 * 3. 最后 3 位游客登舱，摩天轮轮转。当前利润为 11 * $5 - 3 * $6 = $37 。
 * 轮转 3 次得到最大利润，最大利润为 $37 。
 */
class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        //定义变量保存当前等待人数和已游玩人数
        int waiting=0,collected=0,sum= Arrays.stream(customers).sum();
        int cost=0,i=0,running=0,maxRunning=0;
        while (waiting != 0 || collected != sum) {
            //全部上去
            if (i<customers.length){
                waiting+=customers[i++];
            }
            int play=waiting/4==0?waiting:4;
            collected+=play;
            waiting-=play;
            //计算cost
            int currentCost=collected*boardingCost-(++running)*runningCost;
            if (currentCost>cost) {
                maxRunning=running;
                cost=currentCost;
            }
        }
        return cost==0?-1:maxRunning;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minOperationsMaxProfit(new int[]{8, 3}, 5, 6));
        System.out.println(new Solution().minOperationsMaxProfit(new int[]{10,9,6}, 6, 4));
        System.out.println(new Solution().minOperationsMaxProfit(new int[]{3,4,0,5,1}, 1, 92));
        System.out.println(new Solution().minOperationsMaxProfit(new int[]{10,10,6,4,7}, 3, 8));
    }
}