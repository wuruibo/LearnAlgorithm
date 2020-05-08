package BackTracking.P1239;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.
 *
 * Return the maximum possible length of s.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
 * Maximum length is 4.
 * Example 2:
 *
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible solutions are "chaers" and "acters".
 * Example 3:
 *
 * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] contains only lower case English letters.
 */
class Solution {
    private List<String> result=new ArrayList<>();
    private List<String> arr;
    public int maxLength(List<String> arr) {
        this.arr=arr;
        backTracking(0,"");

        int maxLength=0;
        for (String s : result) maxLength=Math.max(s.length(),maxLength);
        return maxLength;
    }
    private void backTracking(int begin,String target){
        result.add(target);
        for (int i = begin; i < arr.size(); i++) {
            if (!duplicated(target,arr.get(i))) {
                target+=arr.get(i);
                backTracking(i+1,target);
                target=target.substring(0,target.length()-arr.get(i).length());
            }
        }

    }
    private boolean duplicated(String last,String add){
        int[] hash=new int[26];
        for (int i = 0; i < last.length(); i++)hash[last.charAt(i)-'a']++;
        for (int i = 0; i < add.length(); i++) hash[add.charAt(i)-'a']++;
        for (int i = 0; i < 26; i++) {
            if (hash[i]>1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] strings={"un","iq","ue"};
        System.out.println(new Solution().maxLength(Arrays.asList(strings)));

        String[] strings1={"cha","r","act","ers"};
        System.out.println(new Solution().maxLength(Arrays.asList(strings1)));


        String[] strings2={"yy","bkhwmpbiisbldzknpm"};
        System.out.println(new Solution().maxLength(Arrays.asList(strings2)));

    }
}