package String.P859;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Example 1:
 *
 * Input: A = "ab", B = "ba"
 * Output: true
 * Example 2:
 *
 * Input: A = "ab", B = "ab"
 * Output: false
 * Example 3:
 *
 * Input: A = "aa", B = "aa"
 * Output: true
 * Example 4:
 *
 * Input: A = "aaaaaaabc", B = "aaaaaaacb"
 * Output: true
 * Example 5:
 *
 * Input: A = "", B = "aa"
 * Output: false
 *
 *
 * Note:
 *
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A and B consist only of lowercase letters.
 *
 * 两种情况可以返回true：
 *
 * 第一种全部的字符都相等并且字符串中存在重复的子字符串
 * 第二种有少于一对长度为2的子字符串可以通过调换变为相等
 *
 *
 */
class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length()!=B.length()) {
            return false;
        }
        if (A.equals(B)) {
            Set<Character> set= new HashSet<>();
            for (char c : A.toCharArray()) {
                set.add(c);
            }
            return set.size()<A.length();
        }
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i)!=B.charAt(i)) {
                list.add(i);
            }
        }
        return list.size()==2 && A.charAt(list.get(0))==B.charAt(list.get(1)) && A.charAt(list.get(1))==B.charAt(list.get(0));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().buddyStrings("abab","abab"));
        System.out.println(new Solution().buddyStrings("aad","aad"));
        System.out.println(new Solution().buddyStrings("aaa","aaa"));
        System.out.println(new Solution().buddyStrings("a","b"));
        System.out.println(new Solution().buddyStrings("aadc","adad"));
        System.out.println(new Solution().buddyStrings("abd","adb"));
        System.out.println(new Solution().buddyStrings("aad","abd"));
        System.out.println(new Solution().buddyStrings("aad","abd"));
        System.out.println(new Solution().buddyStrings("ab","ab"));
        System.out.println(new Solution().buddyStrings("aa","aa"));
        System.out.println(new Solution().buddyStrings("aaaaaabc","aaaaaacb"));
        System.out.println(new Solution().buddyStrings("","aa"));
    }
}