package Contest.Contest12;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
 *
 * 找出 A 中的坡的最大宽度，如果不存在，返回 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[6,0,8,2,1,5]
 * 输出：4
 * 解释：
 * 最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
 * 示例 2：
 *
 * 输入：[9,8,1,0,1,9,4,0,4,1]
 * 输出：7
 * 解释：
 * 最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[9] = 1.
 *
 *
 * 提示：
 *
 * 2 <= A.length <= 50000
 * 0 <= A[i] <= 50000
 */
class Solution {
    public int maxWidthRamp(int[] A) {
        //step1 定义单调递减栈
        Deque<Integer> deque= new ArrayDeque<>();
        for (int i = 0; i < A.length; i++) {
            if (deque.isEmpty() || A[deque.peekLast()]>=A[i]) {
                deque.offerLast(i);
            }
        }
        //step2 从后往前
        int step=0;
        for (int i = A.length-1; i > 0; i--) {
            while (!deque.isEmpty() && A[deque.peekLast()] <= A[i]) {
                int cur=deque.pollLast();
                step=Math.max(step,i-cur);
            }
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxWidthRamp(new int[]{6,0,8,2,1,5}));
        System.out.println(new Solution().maxWidthRamp(new int[]{9,8,1,0,1,9,4,0,4,1}));
    }
}