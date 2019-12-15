package DynamicProgramming.P746;

/**
 * 递归超时
 * 消除重复子问题
 * @autor yeqiaozhu.
 * @date 2019-12-15
 */
public class UsingDP {
    public int minCostClimbingStairs(int[] cost) {
        if (cost==null || cost.length==0) {
            return 0;
        }
        //定义dp问题数组
        int[] dp=new int[cost.length];
        //初始化dp问题
        dp[0]=cost[0];
        dp[1]=cost[1];

        for (int i = 2; i < cost.length; i++) {
            dp[i]=Math.min(dp[i-2],dp[i-1])+cost[i];
        }

        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }

    public static void main(String[] args) {
        int[] ints={1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(new UsingDP().minCostClimbingStairs(ints));

        int[] ints1={10, 15, 20};
        System.out.println(new UsingDP().minCostClimbingStairs(ints1));
    }
}