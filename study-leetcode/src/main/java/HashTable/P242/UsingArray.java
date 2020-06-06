package HashTable.P242;

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

public class UsingArray {

    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) {
            return false;
        }
        //定义hash的数组 索引对应字母
        int[] table=new int[26];

        //将s放入table中
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i)-'a']++;
            //这个写法比较精辟 fork一下
            table[t.charAt(i)-'a']--;
        }
        //判断是否都相等
        for (int j = 0; j < 26; j++) {
            if (table[j]!=0) {
                return false;
            }
        }
        return true;
    }
}

