package DynamicProgramming.P983;

/**
 * 示例 1：
 *
 * 输入：days = [1,4,6,7,8,20], costs = [2,7,15]
 * 输出：11
 * 解释：
 * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
 * 在第 1 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 1 天生效。
 * 在第 3 天，你花了 costs[1] = $7 买了一张为期 7 天的通行证，它将在第 3, 4, ..., 9 天生效。
 * 在第 20 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 20 天生效。
 * 你总共花了 $11，并完成了你计划的每一天旅行。
 * 示例 2：
 *
 * 输入：days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
 * 输出：17
 * 解释：
 * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
 * 在第 1 天，你花了 costs[2] = $15 买了一张为期 30 天的通行证，它将在第 1, 2, ..., 30 天生效。
 * 在第 31 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 31 天生效。
 * 你总共花了 $17，并完成了你计划的每一天旅行。
 *
 */
class Solution {

    public int mincostTickets(int[] days, int[] costs) {
        if (days.length==0) {
            return 0;
        }
        //dp[i]表示完成第i+1天旅行需要的最低票价
        int[] dp=new int[365];
        //先初始化dp数组 如果第i天不需要出门赋值0 如果第i天需要出门赋值-1
        for (int i = 0; i < days.length; i++) {
            dp[days[i]-1]=-1;
        }
        for (int i = 0; i < dp.length; i++) {
            //如果不需要出门
            if (dp[i]==0) {
                dp[i]=i>=1?dp[i-1]:0;
            }else {//需要出门
                int a=i>=1?dp[i-1]+costs[0]:costs[0];
                int b=i>=7?dp[i-7]+costs[1]:costs[1];
                int c=i>=30?dp[i-30]+costs[2]:costs[2];
                dp[i]=Math.min(Math.min(a,b),c);
            }
        }
        return dp[days[days.length-1]-1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mincostTickets(new int[]{1,4,6,7,8,20}, new int[]{2, 7, 15}));
        System.out.println(new Solution().mincostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15}));
    }
}