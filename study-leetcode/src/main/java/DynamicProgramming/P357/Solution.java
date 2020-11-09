package DynamicProgramming.P357;

class Solution {
    int countNumbersWithUniqueDigits(int n){
        if(n > 9 || n < 1) {
            return 1;
        }
        int[] dp=new int[n];
        int result = 10;
        dp[0] = 9;
        for(int i = 1; i < n; i++) {
            dp[i] = (10 - i) * dp[i - 1];
            result += dp[i];
        }

        return result;
    }
}