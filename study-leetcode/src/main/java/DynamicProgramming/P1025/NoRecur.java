package DynamicProgramming.P1025;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yeqiaozhu
 * @date  today
 */
public class NoRecur {
    public boolean divisorGame(int N) {
        boolean[][] dp=new boolean[2][N+1];
        for (int i = 0; i <= N; i++) {
            if (i<=1) {
                dp[1][i]=true;
            }else {
                List<Integer> all = getAll(i);
                for (int j = 0; j < all.size(); j++) {
                    int current = all.get(j);
                    if (dp[1][i - current]) {
                        dp[0][i] = true;
                    }
                    if (dp[0][i - current]) {
                        dp[1][i] = true;
                    }
                }
            }
        }
        return dp[0][N];
    }
    private List<Integer> getAll(int N){
        List<Integer> result= new ArrayList<>();
        for (int i = 1; i < N; i++) {
            if (N%i==0) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new NoRecur().divisorGame(5));
        System.out.println(new NoRecur().divisorGame(2));
        System.out.println(new NoRecur().divisorGame(3));
        System.out.println(new NoRecur().divisorGame(6));
    }
}
