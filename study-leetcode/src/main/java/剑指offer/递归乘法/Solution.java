package 剑指offer.递归乘法;

/**
 * 首先，求得A和B的最小值和最大值;
 * 1.然后，可以对其中的最小值当做乘数（为什么选最小值，因为选最小值当乘数，可以算的少），将其拆分成2的幂的和，即min = a_0 * 2^0 + a_1 * 2^1 + ... + a_i * 2^i + ...min=a
 * 2.取0或者1。其实就是用二进制的视角去看待min，比如12用二进制表示就是1100，即1000+0100。举个例子，13 * 12 = 13 * (8 + 4) = 13 * 8 + 13 * 4 = (13 << 3) + (13 << 2); 具体详见如下代码：
 *
 */
class Solution {
    public int multiply(int A, int B) {
        int min = Math.min(A, B);
        int max = Math.max(A, B);
        int ans = 0;

        for (int i = 0; min != 0; i++) {
            if ((min & 1) == 1) {
                ans += max << i;
            }
            min >>= 1;
        }

        return ans;
    }
}