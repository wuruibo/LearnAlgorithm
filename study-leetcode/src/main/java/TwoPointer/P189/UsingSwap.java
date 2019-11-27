package TwoPointer.P189;

/**
 * O(1) space complexity
 * @autor yeqiaozhu.
 * @date 2019-11-27
 */
public class UsingSwap {

    public void rotate(int[] nums, int k) {
        if (k<0 || nums==null) {
            return;
        }
        k%=nums.length;

        //将nums.length-k次拉到最后面
        for (int i = 0; i < nums.length-k; i++) {
            //将当前元素元素拉到数组最后面
            for (int j = 0; j < nums.length-1; j++) {
                int temp=nums[j+1];
                nums[j+1]=nums[j];
                nums[j]=temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] ints={1,2,3,4,5,6,7,8};
        int[] ints1={1,2};
        new Solution().rotate(ints,3);
        new Solution().rotate(ints1,3);
    }
}
