package String.P1447;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> simplifiedFractions(int n) {
        int denominator = 2;
        List<String> result = new ArrayList<>();
        while (denominator <= n)
        {
            for (int molecular = 1; molecular < denominator; molecular++)
            {
                if (coPrime(denominator, molecular) == 1)
                {
                    result.add(molecular + "/" + denominator);
                }
            }
            denominator++;
        }
        return result;
    }

    /**
     * 辗转相除法 求最大公约数
     * @param m
     * @param n
     * @return
     */
    public static int coPrime(int m, int n)
    {
        if (m == 0 || n == 0)
        {
            return 1;
        }
        if (m % n == 0) {
            return n;
        }
        return coPrime(n, m % n);
    }
}
