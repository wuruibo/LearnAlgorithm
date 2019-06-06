package Digui;

/**
 * @autor yeqiaozhu.
 * @date 2019-05-14
 */
public class Pow {

    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }else {
            //偶数直接转化为子问题
            if((n & 1)==0){
                return myPow(x*x,n/2);
            }else {
                return n<0?1/x*myPow(1/x*1/x,n/2):x*myPow(x*x,n/2);
            }
        }
    }
    public double myPow1(double x, int n) {
        //1.recursion terminater
        if(n == 0){
            return 1;
        }else {
            //2.drill down
            double temp=myPow(x,n/2);

            //偶数直接转化为子问题
            //3.reverse the current level status if needed
            if((n & 1)==0){
                return temp*temp;
            }else {
                return n<0?1/x*temp*temp:x*temp*temp;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(new Pow().myPow(0.00001,
                2147483647));
    }
}
