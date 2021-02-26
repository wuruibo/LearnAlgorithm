package BitManipulation.P342;

/**
 * 1.我们首先检查 num 是否为 2 的幂：x > 0 and x & (x - 1) == 0。
 * 2.num & 0xaaaaaaaa==0
 */
class Solution {
  public boolean isPowerOfFour(int num) {
    return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0xaaaaaaaa) == 0);
  }
}
