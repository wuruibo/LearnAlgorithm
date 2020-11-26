package TwoPointer.P713;

/**
 * 双指针更清晰的版本
 */
public class MoreClear {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int now = 1, times = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            now *= nums[right];
            while (now >= k) {
                now /= nums[left++];
            }
            times += right - left + 1;
        }
        return times;
    }
}
