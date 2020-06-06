package BitManipulation.P191;

/**
 * 计算机上的补码就是算术里的补数。
 *   设我们有一个 4 位的计算机，则其计量范围即模是
 * 2^4 = 16，所以其能够表示的范围是0~15，现在以计算 5 - 3为例，我们知道在计算机中，加法器实现最简单，所以很多运算最终都要转为加法运算，因此5-3就要转化为加法：
 *
 *  # 按以上理论，减一个数等于加上它的补数，所以
 *  5 - 3
 *  # 等价于
 *  5 + (16 - 3)   // 算术运算单元将减法转化为加法
 *  # 用二进制表示则为：
 *  0101 + (10000 - 0011)
 *  # 等价于
 *  0101 + ((1 + 1111) - 0011)
 *  # 等价于
 *  0101 + (1 + (1111 - 0011))
 *  # 等价于
 *  0101 + (1 + 1100) // 括号内是3（0011）的反码+1，正是补码的定义
 *  # 等价于
 *  0101 + 1101
 *  # 所以从这里可以得到
 *  -3 = 1101
 *  # 即 `-3` 在计算机中的二进制表示为 `1101`，正是“ -3 的正值 3（`0011`）的补码（`1101`）”。
 *  # 最后一步 0101 + 1101 等于
 *  10010
 * ————————————————
 * 版权声明：本文为CSDN博主「leonliu06」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/leonliu06/article/details/78685197
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result=0;

        for (int i = 0; i < 32; i++) {
            if ((n & 1)==1) {
                result++;
            }
            n=n>>>1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(-1));
        System.out.println(new Solution().hammingWeight(2));
    }
}