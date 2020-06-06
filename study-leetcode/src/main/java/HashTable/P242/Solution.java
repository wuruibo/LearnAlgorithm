package HashTable.P242;

import java.util.HashMap;
import java.util.Map;

/**
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s==null || t==null || s.length()!=t.length()) {
            return false;
        }
        Map<Character,Integer> inputMap= new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character cur=s.charAt(i);
            inputMap.put(s.charAt(i),inputMap.getOrDefault(cur,0)+1);
        }
        int counter=inputMap.size();
        for (int i = 0; i < t.length(); i++) {
            Character curT=t.charAt(i);
            if (inputMap.containsKey(curT)) {
                Integer oldValue=inputMap.get(curT);
                inputMap.put(curT,oldValue-1);
                if (inputMap.get(curT)==0) {
                    counter--;
                }
            }else {
                return false;
            }
        }
        return counter==0?true:false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isAnagram("anagram","nagaram"));
        System.out.println(new Solution().isAnagram("rat","car"));
    }
}