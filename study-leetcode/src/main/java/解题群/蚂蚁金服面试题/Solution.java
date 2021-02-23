package 解题群.蚂蚁金服面试题;

/**
 *
 * @author yeqiaozhu.
 * @date 1/28/21
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor==0) {
            throw new UnsupportedOperationException("除数不能为0");
        }
        //1.这种情况下会越界 其他情况避免越界统一转化为负数计算 最后添加符号
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        //2.判断符号 异或结果>=0一定为正数
        int sign=dividend^divisor;
        int result = 0;
        //3.统一转换为负数操作(如果用正数操作Integer.MIN_VALUE取反会越界)
        dividend = dividend<0?dividend: opposite(dividend);
        divisor = divisor<0?divisor: opposite(divisor);
        //4.二分思想 每次减去尽可能多的divisor 累加操作次数
        while (dividend <= divisor) {
            int temp = divisor,count = 1;
            while (dividend - temp <= temp) {
                temp = temp << 1;
                count = count << 1;
            }
            dividend -= temp;
            result += count;
        }
        return sign>=0 ? result : opposite(result);
    }
    private int opposite(int x){
        return ~x+1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().divide(Integer.MIN_VALUE,Integer.MIN_VALUE));
        System.out.println(new Solution().divide(Integer.MAX_VALUE,Integer.MAX_VALUE));
        System.out.println(new Solution().divide(Integer.MAX_VALUE,Integer.MIN_VALUE));
        System.out.println(new Solution().divide(Integer.MIN_VALUE,Integer.MAX_VALUE));
    }
}
