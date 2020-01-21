package TwoPointer;

/**
 *
 *
 * 双指针模板版本（先记录一个版本）
 *
 * P209记录下这个解法
 * @autor yeqiaozhu.
 * @date 2020-01-20
 */
public class Template {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0, start = 0, min = Integer.MAX_VALUE;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= s) {
                min = Math.min(min, end - start + 1);
                sum -= nums[start++];
            }
        }
        return (min == Integer.MAX_VALUE) ? 0 : min;
    }
}
