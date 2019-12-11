package BitManipulation.P268;

/**
 * We can harness the fact that XOR is its own inverse to find the missing element in linear time.
 * ​
 *
 * Index	0	1	2	3
 * Value	0	1	3	4
 *
 *
 * missing=4∧(0∧0)∧(1∧1)∧(2∧3)∧(3∧4)
 * =(4∧4)∧(0∧0)∧(1∧1)∧(3∧3)∧2
 * =0∧0∧0∧0∧2
 * =2
 * ​
 *
 * @autor yeqiaozhu.
 * @date 2019-12-11
 */
public class UsingBit {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}
