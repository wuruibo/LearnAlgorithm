package LoogestSubstringNoRe;

import java.util.HashSet;
import java.util.Set;

/**
 * @autor yeqiaozhu.
 * @date 2019-04-24
 */
public class LongestSubstringNoRe {
    public int lengthOfLongestSubstringSlide(String s) {
        Set<Character> set = new HashSet<Character>();
        int i = 0;
        int j = 0;
        int maxLength = 0;
        if(s.length() < 2){
            return s.length();
        }
        while (i < s.length() && j < s.length()) {
            if (set.contains(s.charAt(j))) {
                int tempLength = j - i;
                maxLength = tempLength > maxLength ? tempLength : maxLength;
                set.remove(s.charAt(i++));
            } else {
                set.add(s.charAt(j++));
            }
        }
        int tempLength = j - i;
        maxLength = tempLength > maxLength ? tempLength : maxLength;
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringNoRe().lengthOfLongestSubstringSlide(" "));
    }
}
