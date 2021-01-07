package Contest.Contest46.Problem1;

import java.util.HashSet;
import java.util.Set;

/**
 * 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * 输出：2
 * 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
 */
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set= new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }
        int count=0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (!set.contains(words[i].charAt(j))) {
                    count++;
                    break;
                }
            }
        }
        return words.length-count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"}));
        System.out.println(new Solution().countConsistentStrings("fstqyienx",new String[]{"n","eeitfns","eqqqsfs","i","feniqis","lhoa","yqyitei","sqtn","kug","z","neqqis"}));
    }
}