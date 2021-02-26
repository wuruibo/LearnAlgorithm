package BitManipulation.回文排列;

class Solution {
    public boolean canPermutePalindrome(String s) {
        long highBmp = 0, lowBmp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 64) {
                highBmp ^= 1L << s.charAt(i) - 64;
            } else {
                lowBmp ^= 1L << s.charAt(i);
            }
        }
        return Long.bitCount(highBmp) + Long.bitCount(lowBmp) <= 1;
    }
}