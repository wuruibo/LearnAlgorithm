package BitManipulation.P771;

class Solution {
    public int numJewelsInStones(String J, String S) {
        long xor = 0;
        for (int i = 0; i < J.length(); i++) {
            xor |= 1L << (J.charAt(i) - 'A');
        }
        int res = 0;
        for (int i = 0; i < S.length(); i++) {
            if ((xor & (1L << (S.charAt(i) - 'A'))) != 0) {
                res++;
            }
        }
        return res;
    }
}