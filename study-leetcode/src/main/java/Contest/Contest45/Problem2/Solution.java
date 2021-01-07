package Contest.Contest45.Problem2;

/**
 * 输入：customers = [[1,2],[2,5],[4,3]]
 * 输出：5.00000
 * 解释：
 * 1) 第一位顾客在时刻 1 到达，厨师拿到他的订单并在时刻 1 立马开始做菜，并在时刻 3 完成，第一位顾客等待时间为 3 - 1 = 2 。
 * 2) 第二位顾客在时刻 2 到达，厨师在时刻 3 开始为他做菜，并在时刻 8 完成，第二位顾客等待时间为 8 - 2 = 6 。
 * 3) 第三位顾客在时刻 4 到达，厨师在时刻 8 开始为他做菜，并在时刻 11 完成，第三位顾客等待时间为 11 - 4 = 7 。
 * 平均等待时间为 (2 + 6 + 7) / 3 = 5 。
 */
class Solution {
    public double averageWaitingTime(int[][] customers) {
        double sum=0;
        for (int i = 0,pre=customers[0][0]; i < customers.length; i++) {
            int start=customers[i][0];
            if (start>pre) {
                pre=start;
            }
            int finish=customers[i][1]+pre;
            sum+=finish-start;
            pre=finish;
        }
        return sum/customers.length;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().averageWaitingTime(new int[][]{{1, 2}, {2, 5}, {4, 3}}));
        System.out.println(new Solution().averageWaitingTime(new int[][]{{5,2},{5,4},{10,3},{20,1}}));
    }
}