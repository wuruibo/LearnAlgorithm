package Contest.Contest12.Problem3;

/**
 * 如果n是基数 n是偶数
 */
class Solution {
    public double myPow(double x, int n) {
        if (n==0) {
            return 1;
        }
        double result;
        int time=Math.abs(n);
        if ((n&1)==0) {
            result=myPow(x,time/2)*myPow(x,time/2);
        }else {
            result= x*myPow(x,time/2)*myPow(x,time/2);
        }
        return n<0?(1/result):result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2.00000, 10));
        System.out.println(new Solution().myPow(2.10000, 3));
        System.out.println(new Solution().myPow(2.00000, -2));
        System.out.println(new Solution().myPow(2.00000, 10));
    }
}