package DynamicProgramming.P746;

/**
 * 用递归解决
 * 有重复子问题
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost==null || cost.length==0) {
            return 0;
        }
        return Math.min(recursive(cost,cost.length-1),recursive(cost,cost.length-2));
    }
    private int recursive(int[] cost,int i){
        if (i<0) {
            return 0;
        }
        return Math.min(recursive(cost,i-2),recursive(cost,i-1))+cost[i];
    }

    public static void main(String[] args) {
        int[] ints={1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(new Solution().minCostClimbingStairs(ints));

        int[] ints1={10, 15, 20};
        System.out.println(new Solution().minCostClimbingStairs(ints1));
    }
}