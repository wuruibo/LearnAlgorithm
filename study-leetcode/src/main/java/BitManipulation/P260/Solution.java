package BitManipulation.P260;

public class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int n : nums) {
            diff ^= n;
        }
        //先找出不同的某个位置 根据这个位置将数据分成两组
        diff = Integer.highestOneBit(diff);
        int[] result = { 0, 0 };
        for (int n : nums) {
            //当前位是 0 的组, 然后组内异或
            if ((diff & n) == 0) {
                result[0] ^= n;
                //当前位是 1 的组
            } else {
                result[1] ^= n;
            }
        }
        return result;
    }

}
