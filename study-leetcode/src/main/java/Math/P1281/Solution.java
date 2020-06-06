package Math.P1281;

/**
 * Example 1:
 *
 * Input: n = 234
 * Output: 15
 * Explanation:
 * Product of digits = 2 * 3 * 4 = 24
 * Sum of digits = 2 + 3 + 4 = 9
 * Result = 24 - 9 = 15
 * Example 2:
 *
 * Input: n = 4421
 * Output: 21
 * Explanation:
 * Product of digits = 4 * 4 * 2 * 1 = 32
 * Sum of digits = 4 + 4 + 2 + 1 = 11
 * Result = 32 - 11 = 21
 *
 * Constraints:
 *
 * 1 <= n <= 10^5
 */
class Solution {
    public int subtractProductAndSum(int n) {
        int yushu,chushu=n,addResult=0,chenResult=1;
        while (chushu!=0){
            yushu=chushu%10;
            addResult+=yushu;
            chenResult*=yushu;

            chushu/=10;
        }

        return chenResult-addResult;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subtractProductAndSum(-234));
        System.out.println(new Solution().subtractProductAndSum(4421));
    }
}