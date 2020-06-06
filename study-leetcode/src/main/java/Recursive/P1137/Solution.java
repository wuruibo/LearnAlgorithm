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
 */
class Solution {
    public int tribonacci(int n) {
        if (n<2){return n;}
        if (n==2) {
            return 1;
        }
        return tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().tribonacci(4));
        System.out.println(new Solution().tribonacci(25));
    }
}