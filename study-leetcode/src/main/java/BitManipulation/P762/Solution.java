package BitManipulation.P762;

/**
 * 将 1 ~ 19 中的是否为质数的关系编码到二进制中刚好等于665772
 */
class Solution {
    public int countPrimeSetBits(int L, int R) {
        int res = 0;
        for (int i = L; i <= R; i++) {
            res += 665772 >> Integer.bitCount(i) & 1;
        }
        return res;
    }
}