package Contest.Contest24.Problem2;

class Solution {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length()!=t.length()) {
            return false;
        }
        int[] dict=new int[26];
        for (int i = 0; i < s.length(); i++) {
            int circle=t.charAt(i)-s.charAt(i);
            circle=circle>=0?circle:26+circle;
            if (circle!=0) {
                int temp=dict[circle]*26+circle;
                if (temp>k) {
                    return false;
                }
                dict[circle]++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canConvertString("jicfxaa", "ocxltbp",15));
        System.out.println(new Solution().canConvertString("atmtxzjkz", "tvbtjhvjd", 35));
        System.out.println(new Solution().canConvertString("abc", "bcd", 10));
        System.out.println(new Solution().canConvertString("input", "ouput", 9));
        System.out.println(new Solution().canConvertString("aab", "bbb", 27));
    }
}