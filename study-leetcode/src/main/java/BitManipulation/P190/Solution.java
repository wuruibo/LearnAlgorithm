package BitManipulation.P190;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        //int 32位
        int result=0;
        for (int i = 0; i < 32; i++) {
            //step 1 取出末位
            int end=n & 1;
            //step 2 n右移1位
            n>>=1;
            //step 4 result左移腾出末位
            result<<=1;
            //step 3 result拼接end
            result |= end;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseBits(43261596));
        //System.out.println(new Solution().reverseBits(4294967293));
        System.out.println(-2>>1);
        System.out.println(-2<<1);
        System.out.println(-2>>>1);
    }
}