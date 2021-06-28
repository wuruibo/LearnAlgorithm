package DynamicProgramming.P264;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 这篇题解还比较赞
 * https://leetcode-cn.com/problems/ugly-number-ii/solution/bao-li-you-xian-dui-lie-xiao-ding-dui-dong-tai-gui/
 */
class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return -1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int id2 = 0, id3 = 0, id5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[id2] * 2, Math.min(dp[id3] *3, dp[id5] * 5));
            // 这里不用else if的原因是有可能id2(3) * 2 == id3(2) * 3
            // 这种情况两个指针都要后移
            if (dp[id2] * 2 == dp[i]) {
                id2 += 1;
            }
            if (dp[id3] * 3 == dp[i]) {
                id3 += 1;
            }
            if (dp[id5] * 5 == dp[i]) {
                id5 += 1;
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {

        int[][] array={{0,1},{0,-1}};
        String s="aest";
        int i = s.charAt(0);
        System.out.println(i);
        Arrays.sort(array,Comparator.comparingInt(a->a[0]));
        System.out.println(Math.ceil(1.2));
        double result=0.0;
        BigDecimal bg = new BigDecimal(result).setScale(2, RoundingMode.UP);
        System.out.println(bg.doubleValue() <= 1.0);
    }
    private long transfer(String word){
        StringBuilder res=new StringBuilder();
        for(int i=0;i<word.length();i++){
            res.append(word.charAt(i));
        }
        return 0;
    }
}