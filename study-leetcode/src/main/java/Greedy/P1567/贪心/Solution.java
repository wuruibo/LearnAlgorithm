package Greedy.P1567.贪心;

/**
 * 设 POS[i] 是以 nums[i] 结尾，乘积为正的最长子数组的长度。
 *
 * 设 NEG[i] 是以 nums[i] 结尾，乘积为负的最长子数组的长度。
 *
 * 为了编写代码方便，设 nums 下标从 1 开始。那么 POS[0] = NEG[0] = 0。
 *
 * 接下来讨论一下 nums[i] 的值如何影响 POS[i] 及 NEG[i] 的计算。
 *
 * 当 nums[i] 为 0 时，显然有 POS[i] = NEG[i] = 0，即这样的子数组不存在。
 * 当 nums[i] 为正时：
 * POS[i] = POS[i-1] + 1。
 * NEG[i] = NEG[i-1] ? (NEG[i-1] + 1) : 0。
 * 为何计算NEG[i]时要判断 NEG[i-1] 不为 0 ？因为 nums[i] 自己没法成为一个乘积为负的数组。
 * 当 nums[i] 为负时：
 * POS[i] = NEG[i-1] ? (NEG[i-1] + 1) : 0。 判断 NEG[i-1] 是否为 0 的原因同上。
 * NEG[i] = POS[i-1] + 1;
 */
public class Solution {
    public int getMaxLen(int[] nums) {
        // int[] negMul = new int[nums.length+1];
        // int[] posMul = new int[nums.length+1];
        int negMul = 0, posMul = 0;
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                posMul = posMul+1;
                if(negMul > 0) {
                    // 确保negMul是存在的
                    negMul = negMul+1;
                }
            } else if(nums[i] < 0) {
                // 临时保存
                int tmp = negMul;
                negMul = posMul+1;
                // 前面没有负值必须重置为0
                posMul = tmp > 0 ? tmp+1 : 0;
            } else {
                // 不可省略
                posMul = negMul = 0;
            }
            ans = Math.max(ans, posMul);
        }
        return ans;
    }
}
