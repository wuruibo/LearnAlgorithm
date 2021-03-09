package Contest.Contest51.Problem2;

import java.util.Arrays;

/**
 * 输入：nums = [1,-1,1], limit = 3, goal = -4
 * 输出：2
 * 解释：可以将 -2 和 -3 添加到数组中，数组的元素总和变为 1 - 1 + 1 - 2 - 3 = -4 。
 * 示例 2：
 *
 * 输入：nums = [1,-10,9,1], limit = 100, goal = 0
 * 输出：1
 */
class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum=Arrays.stream(nums).boxed().mapToLong(Integer::intValue).sum();
        long target=Math.abs(goal-sum);
        long count=target%limit==0?target/limit:target/limit+1;
        return  (int) count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minElements(new int[]{1, -1, 1}, 3, -4));
        System.out.println(new Solution().minElements(new int[]{1,-10,9,1}, 100, 0));
        System.out.println(new Solution().minElements(new int[]{1, -1, 1}, 3, -4));
    }
}