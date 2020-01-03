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
 * @autor yeqiaozhu.
 * @date 2020-01-03
 */
public class UsingDPNoSpace {
    public int tribonacci(int n) {
        if (n<2){ return n;}
        if (n==2) {return 1;}
        int now=2,first=1,second=1,third=0;

        for (int i = 2; i < n; i++) {
            now=first+second+third;
            third=second;
            second=first;
            first=now;
        }
        return now;
    }

    public static void main(String[] args) {
        System.out.println(new UsingDPNoSpace().tribonacci(4));
        System.out.println(new UsingDPNoSpace().tribonacci(25));
    }
}
