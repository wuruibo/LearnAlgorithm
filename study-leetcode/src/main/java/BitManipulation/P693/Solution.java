package BitManipulation.P693;

/**
 * @author yeqiaozhu.
 * @date 2/26/21
 */
public class Solution {
    public boolean hasAlternatingBits(int n) {

        int prev = n & 1;

        while (n != 0) {
            n >>= 1;
            int cur = n & 1;
            if (cur == prev) {
                return false;
            }
            prev = cur;
        }

        return true;
    }
}
