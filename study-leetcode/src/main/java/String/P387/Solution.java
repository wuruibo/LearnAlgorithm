package String.P387;

/**
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 */
class Solution {
    public int firstUniqChar(String s) {
        int[] temp=new int[26];
        for (int i = 0; i < s.length(); i++) {
            temp[s.charAt(i)-'a']++;
        }

        for (int j = 0; j < s.length(); j++) {
            if (temp[s.charAt(j)-'a']==1) {
                return j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().firstUniqChar("leetcode"));
        System.out.println(new Solution().firstUniqChar("lee"));
        System.out.println(new Solution().firstUniqChar(""));
        System.out.println(new Solution().firstUniqChar("loveleetcode"));
    }
}