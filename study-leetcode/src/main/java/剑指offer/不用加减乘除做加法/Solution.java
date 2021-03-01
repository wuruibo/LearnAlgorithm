package 剑指offer.不用加减乘除做加法;

/**
 * @author yeqiaozhu.
 * @date 2/28/21
 */
class Solution {
    public int add(int a, int b) {
        // 当进位为 0 时跳出
        while(b != 0) {
            // c = 进位
            int c = (a & b) << 1;
            // a = 非进位和
            a ^= b;
            // b = 进位
            b = c;
        }
        return a;
    }
}
