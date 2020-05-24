package Contest.ContestC.Problem2;

/**
 * 给你字符串 s 和整数 k 。
 *
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 *
 * 英文中的 元音字母 为（a, e, i, o, u）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abciiidef", k = 3
 * 输出：3
 * 解释：子字符串 "iii" 包含 3 个元音字母。
 * 示例 2：
 *
 * 输入：s = "aeiou", k = 2
 * 输出：2
 * 解释：任意长度为 2 的子字符串都包含 2 个元音字母。
 * 示例 3：
 *
 * 输入：s = "leetcode", k = 3
 * 输出：2
 * 解释："lee"、"eet" 和 "ode" 都包含 2 个元音字母。
 * 示例 4：
 *
 * 输入：s = "rhythms", k = 4
 * 输出：0
 * 解释：字符串 s 中不含任何元音字母。
 * 示例 5：
 *
 * 输入：s = "tryhard", k = 4
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 10^5
 * s 由小写英文字母组成
 * 1 <= k <= s.length
 */
class Solution {
    public int maxVowels(String s, int k) {
        if (k>s.length()) return 0;
        char[] chars={'a','e','i','o','u'};
        int[] hash=new int[26];
        for (char c : chars) {
            hash[c-'a']++;
        }
        //初始化一下
        int max=0,count=0,begin=0,end=0;
        while (end<k) {
            count += hash[s.charAt(end++) - 'a'];
        }
        max=Math.max(count,max);

        while (end<s.length()){
            count-=hash[s.charAt(begin++)-'a'];
            count+=hash[s.charAt(end++)-'a'];
            max=Math.max(count,max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxVowels("aeiou",2));
        System.out.println(new Solution().maxVowels("abciiidef",3));
        System.out.println(new Solution().maxVowels("abciiidef",11));
        System.out.println(new Solution().maxVowels("aeiou",2));
        System.out.println(new Solution().maxVowels("leetcode",3));
        System.out.println(new Solution().maxVowels("rhythms",4));
        System.out.println(new Solution().maxVowels("tryhard",4));
    }
}