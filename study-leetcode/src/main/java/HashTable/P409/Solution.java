package HashTable.P409;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestPalindrome(String s) {
        Map<Character,Integer> sMap= new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char current=s.charAt(i);
            sMap.put(current,sMap.getOrDefault(current,0)+1);
        }
        int count=0;
        for (Map.Entry<Character, Integer> characterIntegerEntry : sMap.entrySet()) {
            int value=characterIntegerEntry.getValue();
            count+=(value-value%2);
        }
        return count<s.length()?count+1:count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("abccccdd"));
        System.out.println(new Solution().longestPalindrome("a"));
        System.out.println(new Solution().longestPalindrome("aabb"));
        System.out.println(new Solution().longestPalindrome("aabbcd"));
        System.out.println(new Solution().longestPalindrome("aabbcccd"));
    }
}