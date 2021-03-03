package 剑指offer.翻转数位;

class Solution {
    public int reverseBits(int num) {
        int maxLen = 0, preLen = 0, curLen = 0, bits = 32;
        while (bits-- > 0) {
            if ((num & 1) == 0) {
                curLen -= preLen;
                preLen = curLen + 1;
            }
            curLen++;
            maxLen = Math.max(maxLen, curLen);
            num >>>= 1;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseBits(1775));
        System.out.println(new Solution().reverseBits(7));
        System.out.println(new Solution().reverseBits(1));
        System.out.println(new Solution().reverseBits(-4));
        System.out.println(new Solution().reverseBits(2147483647));
        System.out.println(Integer.toBinaryString(-4));
        System.out.println(Integer.toBinaryString(-4>>2));
        System.out.println(Integer.toBinaryString(-4>>>2));
    }
}