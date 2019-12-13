package BitManipulation.P371;

/**
 * 通过异或操作（^）让每个位置得到对应的数值，但是会把进位丢掉
 * 通过与操作（&）得到每个位置的进位
 * 负数以补码的形式存在 二进制不管符号位直接相加
 * 二进制相加
 */
class Solution {
    public int getSum(int a, int b) {
        int c;
        while(b !=0 ) {
            c = (a&b);
            a = a ^ b;
            b = (c)<<1;
        }
        return a;

    }


    public static void main(String[] args) {
        System.out.println(new Solution().getSum(-3,2));
        String string=Integer.toBinaryString(-3);
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(-2));
        System.out.println(Integer.toBinaryString(-2-3));
        //System.out.println(Integer.parseInt(string,10));
    }
}