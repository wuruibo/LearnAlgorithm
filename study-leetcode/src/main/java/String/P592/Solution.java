package String.P592;

import java.util.Scanner;

class Solution {
    public String fractionAddition(String expression) {
        Scanner sc = new Scanner(expression).useDelimiter("/|(?=[-+])");
        int A = 0;
        int B = 1;
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            A = A * b + B * a;
            B = b * B;
            int g = gcd(A, B);
            A /= g;
            B /= g;
        }
        return A + "/" + B;
    }

    /**
     * 辗转相除法求最大公约数
     * @param x
     * @param y
     * @return
     */
    int gcd(int x, int y) {
        if (y == 0) {
            return Math.abs(x);
        }
        return gcd(y, x % y);
    }
}
