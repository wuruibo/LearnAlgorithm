package DynamicProgramming.P198;

/**
 * 不需要保存所有的值
 *
 * @autor yeqiaozhu.
 * @date 2019-12-14
 */
public class DPNoSpace {
    /* the order is: prev2, prev1, num  */
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
    }
}
