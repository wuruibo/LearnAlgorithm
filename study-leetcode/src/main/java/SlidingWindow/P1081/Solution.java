package SlidingWindow.P1081;


import java.util.*;

/**
 * 返回字符串 text 中按字典序排列最小的子序列，该子序列包含 text 中所有不同字符一次。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："cdadabcc"
 * 输出："adbc"
 * 示例 2：
 *
 * 输入："abcd"
 * 输出："abcd"
 * 示例 3：
 *
 * 输入："ecbacba"
 * 输出："eacb"
 * 示例 4：
 *
 * 输入："leetcode"
 * 输出："letcod"
 *
 * 枚举超时版本
 *
 */
class Solution {
    private List<String> result= new ArrayList<>();
    private Integer size;
    private String s;
    public String smallestSubsequence(String s) {
        Set<Character> set= new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        this.size=set.size();
        this.s=s;
        dfs(new StringBuilder(),0,new HashSet<>());
        Collections.sort(result);

        return result.get(0);
    }
    private void dfs(StringBuilder temp,int start,Set<Character> tempSet){
        if (temp.length()==size) {
            result.add(new String(temp));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            Character key=s.charAt(i);
            if (!tempSet.contains(key)) {
                tempSet.add(key);
                temp.append(key);
                dfs(temp,i+1,tempSet);
                temp.deleteCharAt(temp.length()-1);
                tempSet.remove(key);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().smallestSubsequence("cdadabcc"));
        System.out.println(new Solution().smallestSubsequence("abcd"));
        System.out.println(new Solution().smallestSubsequence("ecbacba"));
        System.out.println(new Solution().smallestSubsequence("leetcode"));
        System.out.println(new Solution().smallestSubsequence("1"));
    }
}