package Array.P747;

/**
 * @author yeqiaozhu.
 * @date 12/17/20
 */
public class Solution {
    public int dominantIndex(int[] nums) {
        int max = 0, idx = 0, less = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                less = max;
                max = nums[i];
                idx = i;
            } else if (nums[i] > less) {
                less = nums[i];
            }
        }
        return max >= (less * 2) ? idx : -1;
    }
}
