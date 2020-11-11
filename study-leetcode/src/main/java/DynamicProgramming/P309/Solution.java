package DynamicProgramming.P309;

/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 */
class Solution {
    /**
     * 0.不持股且当天没卖出,定义其最大收益dp[i][0];     dp[i][0]=max(dp[i-1][0],dp[i-1][2])
     * 1.持股,定义其最大收益dp[i][1]；                dp[i][1]=max(dp[i-1][1],dp[i-1][0]-prices[i])
     * 2.不持股且当天卖出了，定义其最大收益dp[i][2]；   dp[i][2]=dp[i-1][1]+prices[i]
     *
     *
     * 总共三种状态
     * 1.不持股 && 能购买 dp[i][0]=Math.max(dp[i-1][2]+prices[i],dp[i-1][0])
     *      可以由两种状态转换过来 对应选择卖出或者不卖出
     * 2.持股 dp[i][1]=Math.max(dp[i-1][0]-current,dp[i-1][1])
     *      可以由两种状态转换过来 对应选择当前买入或者不买入
     * 3.不持股 && 不能购买 dp[i][2]=dp[i-2][2]+prices[i-1]
     *      只能由一种状态转换过来 大前天持股 前一天卖出
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][3];
        int max=0;
        for (int i = 0; i < prices.length; i++) {
            if (i==0) {
                dp[0][0]=0;//本来就不持有，啥也没干
                dp[0][1]=-1*prices[0];//第0天只买入
                dp[0][2]=0;//可以理解成第0天买入又卖出，那么第0天就是“不持股且当天卖出了”这个状态了，其收益为0，所以初始化为0是合理的
            }else {
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]);
                dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
                dp[i][2] = dp[i-1][1]+prices[i];
            }
            max = Math.max(Math.max(Math.max(dp[i][2], dp[i][0]), dp[i][1]), max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{1,2,3,0,2}));
    }
}