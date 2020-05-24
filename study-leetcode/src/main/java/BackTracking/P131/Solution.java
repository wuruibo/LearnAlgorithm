package BackTracking.P131;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
class Solution {
    List<List<String>> result= new ArrayList<>();
    public List<List<String>> partition(String s) {
        backTracking(0,s,new ArrayList<>());
        return result;
    }
    void backTracking(int begin,String s,List<String> temp){
        if (begin==s.length()) result.add(new ArrayList<>(temp));

        for (int i = begin; i < s.length(); i++) {
            //判断如果是回文的话可以往下继续走
            if (palindrome(s,begin,i)) {
                temp.add(s.substring(begin,i+1));
                backTracking(i+1,s,temp);
                temp.remove(temp.size()-1);
            }
        }
    }

    /**
     * 判断回文
     * @param s
     * @param begin
     * @param end
     * @return
     */
    private Boolean palindrome(String s,int begin,int end){
        while (begin<end && s.charAt(begin)==s.charAt(end)){begin++;end--;}
        return begin>=end;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().partition("aab").toString());
        System.out.println(new Solution().partition("").toString());
        System.out.println(new Solution().partition("aaaab").toString());
    }
}