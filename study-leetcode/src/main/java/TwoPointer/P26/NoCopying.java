package TwoPointer.P26;

/**
 * 不能有拷贝
 * No Copying Using Two Pointer
 * @autor yeqiaozhu.
 * @date 2019-11-18
 */
public class NoCopying {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
