package BitManipulation.消失的数字;

/**
 * 利用异或的特性，res = res ^ x ^ x。
 * 对同一个值异或两次，那么结果等于它本身，所以我们对res从0-nums.length进行异或，
 * 同时对nums数组中的值进行异或，出现重复的会消失，所以最后res的值是只出现一次的数字，也就是nums数组中缺失的那个数字。
 *
 * 0和任何值的异或等于本身，即：A ^ 0 = A
 * 异或本身等于0，即 A ^ A = 0
 * 异或满足结合律，即 A ^ B ^ C = A ^ ( B ^ C)
 */
class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            res ^= i;
            res ^= nums[i];
        }
        res ^= nums.length;

        return res;
    }
}