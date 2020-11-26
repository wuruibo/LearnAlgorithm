package 剑指offer.P48;

import java.util.HashSet;
import java.util.Set;

/**
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set= new HashSet<>();
        int max=0;
        for (int r = 0,l=0; r < s.length(); r++) {
            while (!set.add(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            max=Math.max(max,r-l+1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("a"));
    }
}