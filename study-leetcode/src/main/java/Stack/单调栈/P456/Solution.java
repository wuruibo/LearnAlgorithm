package Stack.单调栈.P456;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 *
 * 注意：n 的值小于15000。
 *
 * 示例1:
 *
 * 输入: [1, 2, 3, 4]
 *
 * 输出: False
 *
 * 解释: 序列中不存在132模式的子序列。
 * 示例 2:
 *
 * 输入: [3, 1, 4, 2]
 *
 * 输出: True
 *
 * 解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
 * 示例 3:
 *
 * 输入: [-1, 3, 2, 0]
 * 输出: True
 * 解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
 *
 */
class Solution {
    /**
     *
     * 这道题用的是单调栈
     * 倒着遍历数组，维护单调减栈，当来数字大于栈顶，弹出栈顶赋予second，相当于找到次大值，如果出现比次大小数，返回true
     * @param nums
     * @return
     */
    public boolean find132pattern(int[] nums) {
        Integer second=Integer.MIN_VALUE;
        Deque<Integer> deque= new LinkedList<>();
        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[i]<second) {
                return true;
            }
            while (!deque.isEmpty() && deque.peekLast()<nums[i]){
                second=deque.pollLast();
            }
            deque.offerLast(nums[i]);
        }
        return false;
    }
}