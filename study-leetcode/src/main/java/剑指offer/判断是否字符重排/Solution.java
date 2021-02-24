package 剑指offer.判断是否字符重排;

/**
 * 貌似没有理论依据
 * 测试用例不够
 */
class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        long result = 0;
        int len1 = s1.length(), len2 = s2.length();
        if (len1 != len2) {
            return false;
        }
        for (int i = 0; i < len1; i++) {
            result += 1 << (s1.charAt(i) - 'a');
            result -= 1 << (s2.charAt(i) - 'a');
        }
        return result == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().CheckPermutation("cd", "ac"));
    }
}