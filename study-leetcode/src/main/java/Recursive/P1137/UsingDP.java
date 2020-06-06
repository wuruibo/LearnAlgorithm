package Recursive.P1137;

/**
 * Example 1:
 *
 * Input: n = 4
 * Output: 4
 * Explanation:
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * Example 2:
 *
 * Input: n = 25
 * Output: 1389537
 *
 *
 * @autor yeqiaozhu.
 * @date 2020-01-03
 */
public class UsingDP {
    public int tribonacci(int n) {
        if (n<2){ return n;}
        if (n==2) {return 1;}
        int[] temp=new int[n+1];
        temp[0]=0;
        temp[1]=1;
        temp[2]=1;

        for (int i = 3; i < n+1; i++) {
            temp[i]=temp[i-1]+temp[i-2]+temp[i-3];
        }
        return temp[n];

    }

    public static void main(String[] args) {
        System.out.println(new UsingDP().tribonacci(4));
        System.out.println(new UsingDP().tribonacci(25));
    }

}
