package P287;

import java.util.Arrays;

/**
 * @autor yeqiaozhu.
 * @date 2019-10-21
 */
public class UsingSort {

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i]==nums[i+1]) {
                return nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] ints={1,3,4,2,2};
        new UsingSort().findDuplicate(ints);
    }
}
