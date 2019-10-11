package P169;

import java.util.Arrays;

/**
 * 时间复杂度O(NlogN)
 * 空间复杂度O(1）
 * @autor yeqiaozhu.
 * @date 2019-10-10
 */
public class UsingArraySort {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return nums[len/2];
    }
}
