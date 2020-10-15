package 剑指offer.P38;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    private String s;
    public String[] permutation(String s) {
        this.s=s;
        List<String> result= new ArrayList<>();
        backTracking(result,new StringBuilder(),new int[s.length()]);
        System.out.printf(result.toString());
        return result.toArray(new String[result.size()]);
    }
    private void backTracking(List<String> result,StringBuilder temp,int[] visited){
        if (temp.length()==s.length()) {
            result.add(new String(temp));
            return;
        }
        Set<Character> set= new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (visited[i]==0 && set.add(s.charAt(i))) {
                temp.append(s.charAt(i));
                visited[i]=1;
                backTracking(result,temp,visited);
                visited[i]=0;
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        new Solution().permutation("abc");
    }
}