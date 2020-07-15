package Contest.Contest9.Problem2;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[][] hash=new int[strs.length][];
        for (int i = 0; i < strs.length; i++) {
            String current=strs[i];
            int[] temp=new int[current.length()];
            for (int j = 0; j < current.length(); j++) {
                temp[current.charAt(j)-'a']++;
            }
            hash[i]=temp;
        }
        //遍历
        List<List<String>> result=new ArrayList<>();
        for (int i = 0; i < hash.length; i++) {
            List<String> temp= new ArrayList<>();
            temp.add(strs[i]);
            int[] first=hash[i];
            for (int j = i+1; j < hash.length; j++) {
                if (equalsArray(first,hash[j])) {
                    temp.add(strs[j]);
                }
            }
            result.add(temp);
        }
        return result;
    }
    private boolean equalsArray(int[] ints1,int[] ints2){
        if (ints1.length!=ints2.length) {
            return false;
        }
        for (int i = 0; i < ints1.length; i++) {
            if (ints1[i]!=ints2[i]) {
                return false;
            }
        }
        return true;
    }
}