package BackTracking.P08;

import java.util.*;

/**
 * 面试题 08.08. 有重复字符串的排列组合
 * 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
 *
 * 示例1:
 *
 *  输入：S = "qqe"
 *  输出：["eqq","qeq","qqe"]
 * 示例2:
 *
 *  输入：S = "ab"
 *  输出：["ab", "ba"]
 * 提示:
 *
 * 字符都是英文字母。
 * 字符串长度在[1, 9]之间。
 */
class Solution {
    public String[] permutation(String S) {
        int[] visited=new int[S.length()];
        List<String> result= new ArrayList<>();
        backTracking(visited,S,result,new StringBuilder());

        String[] convert=new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            convert[i]=result.get(i);
        }
        return convert;
    }
    private void backTracking(int[] visited,String S, List<String> result,StringBuilder tempString){
        if (tempString.length()==visited.length) {
            result.add(tempString.toString());
            return;
        }
        Set<Character> set= new HashSet<>();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]==0 && set.add(S.charAt(i))) {
                visited[i]=1;
                tempString.append(S.charAt(i));
                backTracking(visited,S,result,tempString);
                tempString.deleteCharAt(tempString.length()-1);
                visited[i]=0;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permutation("qqe"));
        System.out.println(new Solution().permutation("a"));
    }
}