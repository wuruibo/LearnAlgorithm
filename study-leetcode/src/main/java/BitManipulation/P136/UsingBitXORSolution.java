package BitManipulation.P136;

/**
 * @autor yeqiaozhu.
 * @date 2019-09-20
 */
public class UsingBitXORSolution {
    public int singleNumber(int[] nums) {
        int start=nums[0];
        for (int i = 1; i < nums.length; i++) {
            start^=nums[i];
        }
        return start;
    }

    public static void main(String[] args) {
        int[] ints1={4,1,2,1,2};
        System.out.println(new Solution().singleNumber(ints1));
    }
}
