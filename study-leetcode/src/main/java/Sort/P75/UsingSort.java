package Sort.P75;

/**
 * @autor yeqiaozhu.
 * @date 2020-01-19
 */
public class UsingSort {
    //-------------  SOLUTION 2: 1 SCAN ----------------//
    // 3-way partition used in quick sort
    public void sortColors(int[] nums) {
        int lt = 0, i = 0, gt = nums.length - 1;
        while (i <= gt) {
            if (nums[i] == 0) {
                swap(nums, lt++, i++);
            } else if (nums[i] == 2) {
                swap(nums, i, gt--);
            } else { // nums[i] == 1
                i++;
            }
        }
    }
    private void swap(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }
}
