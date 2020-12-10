package Contest.Contest41.Problem3;

class Solution {
    public int concatenatedBinary(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (char c : Integer.toBinaryString(i).toCharArray()) {
                if (c == '1') {
                    res = 2 * res + 1;
                } else {
                    res = 2 * res;
                }
                res %= 1000000007;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String temp="1101110010111011110001001101010111100";
        String teme="1101110010111011110001001101010111100";

        System.out.println(new Solution().concatenatedBinary(1));
        System.out.println(new Solution().concatenatedBinary(3));
        System.out.println(new Solution().concatenatedBinary(12));
    }
}