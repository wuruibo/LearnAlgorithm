package Recursive.P509;

/**
 * @autor yeqiaozhu.
 * @date 2020-01-03
 */
public class UsingDP {
    public int fib(int N) {
        if (N<2){
            return N;
        }
        int first=1,second=0,now=1;

        for (int i = 1; i < N; i++) {
            now=first+second;
            second=first;
            first=now;
        }
        return now;
    }

    public static void main(String[] args) {
        System.out.println(new UsingDP().fib(2));
        System.out.println(new UsingDP().fib(3));
    }
}