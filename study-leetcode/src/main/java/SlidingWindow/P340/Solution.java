package SlidingWindow.P340;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，找出 至多 包含 k 个不同字符的最长子串 T。
 *
 * 示例 1:
 *
 * 输入: s = "eceba", k = 2
 * 输出: 3
 * 解释: 则 T 为 "ece"，所以长度为 3。
 * 示例 2:
 *
 * 输入: s = "aa", k = 1
 * 输出: 2
 * 解释: 则 T 为 "aa"，所以长度为 2。
 *
 */
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character,Integer> hash= new HashMap<>(16);
        int max=0;
        for (int r = 0,l=0; r < s.length(); r++) {
            //直接加入到Map中
            Character current=s.charAt(r);
            if (!hash.containsKey(current) || hash.get(current)==0) {
                hash.put(current,1);
                k--;
            }else {
                hash.put(current,hash.get(current)+1);
            }
            //如果k==0 说明当前窗口有效 移动左边的指针
            while (k < 0) {
                //移动左边的指针
                Character pre=s.charAt(l);
                hash.put(pre,hash.get(pre)-1);
                if (hash.get(pre)==0) {
                    k++;
                }
                l++;
            }
            max=Math.max(max,r-l+1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstringKDistinct("eceba", 2));
        System.out.println(new Solution().lengthOfLongestSubstringKDistinct("aa", 0));
        System.out.println(new Solution().lengthOfLongestSubstringKDistinct("eceba", 2));
        System.out.println(new Solution().lengthOfLongestSubstringKDistinct("a", 2));
        System.out.println(new Solution().lengthOfLongestSubstringKDistinct("aa", 1));
        System.out.println(new Solution().lengthOfLongestSubstringKDistinct("ccaabbb", 2));
    }
}