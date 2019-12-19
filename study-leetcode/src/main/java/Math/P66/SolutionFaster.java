package Math.P66;

/**
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * @autor yeqiaozhu.
 * @date 2019-12-19
 */
public class SolutionFaster {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i]<9) {
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        digits=new int[digits.length+1];
        digits[0]=1;

        return digits;
    }
}