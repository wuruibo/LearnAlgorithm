package BitManipulation.剑指offer15;

public class Solution {
    /**
     * you need to treat n as an unsigned value
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count=0;
        while (n != 0) {
            count+=(n&1);
            n=n>>1;
        }
        return count;
    }
}