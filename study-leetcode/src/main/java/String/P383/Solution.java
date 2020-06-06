package String.P383;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        Map<Character,Integer> magazineMap= new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            Character current=magazine.charAt(i);
            Integer count=magazineMap.getOrDefault(current,0);
            magazineMap.put(current,count+1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            Character left=ransomNote.charAt(i);
            if (magazineMap.getOrDefault(left,0)>0) {
                magazineMap.put(left,magazineMap.get(left)-1);
            }else {
                return false;
            }
        }
        return true;
     }
    public boolean canConstructUsingArray(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--arr[ransomNote.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canConstruct("a", "b"));
        System.out.println(new Solution().canConstruct("", "b"));
        System.out.println(new Solution().canConstruct("a", ""));
        System.out.println(new Solution().canConstruct("aa", "ab"));
        System.out.println(new Solution().canConstruct("aa", "aab"));

        System.out.println(130*7-300-865*0.65);
    }
}