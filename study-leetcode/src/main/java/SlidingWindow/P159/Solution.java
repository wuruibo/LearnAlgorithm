package SlidingWindow.P159;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t ，并返回该子串的长度。
 *
 * 示例 1:
 *
 * 输入: "eceba"
 * 输出: 3
 * 解释: t 是 "ece"，长度为3。
 * 示例 2:
 *
 * 输入: "ccaabbb"
 * 输出: 5
 * 解释: t 是 "aabbb"，长度为5
 */
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character,Integer> hashMap= new HashMap<>(16);
        int max=0,holder=2,counter=0;
        for (int end = 0,begin=0; end < s.length(); end++) {
            while (counter > holder) {
                Character left=s.charAt(begin);
                hashMap.put(left,hashMap.getOrDefault(left,0)-1);
                if (hashMap.getOrDefault(left,0)==0) {
                    counter--;
                }
                begin++;
            }
            Character right=s.charAt(end);
            if (hashMap.getOrDefault(right,0)==0) {
                counter++;
            }
            hashMap.put(right,hashMap.getOrDefault(right,0)+1);

            if (counter<=holder) {
                max=Math.max(max,end-begin+1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstringTwoDistinct("eceba"));
        System.out.println(new Solution().lengthOfLongestSubstringTwoDistinct("a"));
        System.out.println(new Solution().lengthOfLongestSubstringTwoDistinct("ccaabbb"));
    }
}