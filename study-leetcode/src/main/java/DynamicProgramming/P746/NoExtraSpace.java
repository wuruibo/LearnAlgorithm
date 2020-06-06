package DynamicProgramming.P746;

/**
 * 在dp的基础上只保留前几项
 *
 * @autor yeqiaozhu.
 * @date 2019-12-15
 */
public class NoExtraSpace {
    public int minCostClimbingStairs(int[] cost) {
        if (cost==null || cost.length==0) {
            return 0;
        }
        //定义dp问题数组
        int preTwo=0;
        int preOne=cost[0];
        int current;

        for (int i = 1; i < cost.length; i++) {
            current=Math.min(preOne,preTwo)+cost[i];
            preTwo=preOne;
            preOne=current;
        }

        return Math.min(preOne,preTwo);

    }

    public static void main(String[] args) {
        int[] ints={1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(new NoExtraSpace().minCostClimbingStairs(ints));

        int[] ints1={10, 15, 20};
        System.out.println(new NoExtraSpace().minCostClimbingStairs(ints1));
    }

}
