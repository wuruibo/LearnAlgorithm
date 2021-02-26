package BitManipulation.P476;

/**
 * 就是num转为二进制，并看看总共x位二进制，然后与这全部的x位都是1的二进制进行异或运算（相同为0，不同为1）。就得出结果。
 */
class Solution {
    public int findComplement(int num) {
        int temp = num, c = 0;
        while(temp > 0){
             //根据判断条件
            //二进制右移并赋值给temp，
            temp >>= 1;
           //二进制左移之后结果+1 赋值给c
            c =  (c << 1) + 1;
        }
        return num ^ c;
    }
}