package TwoPointer.P392;

/**
 * 判断一个字符串是否存在于另一个字符串中
 * 字符串不完全匹配
 *
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        //双指针解法
        int first=0,second=0;
        while (second<t.length()){
            if (s.charAt(first)==t.charAt(second)) {
                first++;
            }
            second++;
        }
        return first==s.length();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isSubsequence("abc", "ahbgdc"));
        System.out.println(new Solution().isSubsequence("axc", "ahbgdc"));
    }
}