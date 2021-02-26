package BitManipulation.P231;

/**
 *
 * 恒有 n & (n - 1) == 0，这是因为：
 * 1.二进制最高位为 1，其余所有位为 0；
 * 2.n−1 二进制最高位为 0，其余所有位为 1；
 * 3.一定满足 n > 0。
 *
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(0));
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(-4));
    }
}