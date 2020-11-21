package BackTracking.P767;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public String reorganizeString(String S) {
        char[] chars=S.toCharArray();
        boolean[] visited=new boolean[S.length()];
        return dfs(chars,new StringBuilder(),visited);
    }
    private String dfs(char[] chars,StringBuilder temp,boolean[] visited){
        if (temp.length()==chars.length) {
            return temp.toString();
        }
        Set<Character> set= new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (!visited[i] && set.add(chars[i]) && valid(temp,chars[i])) {//可添加
                visited[i]=true;
                temp.append(chars[i]);
                String sub=dfs(chars,temp,visited);
                if (!sub.equals("")) {
                    return sub;
                }
                temp.deleteCharAt(temp.length()-1);
                visited[i]=false;
            }
        }
        return "";
    }
    private boolean valid(StringBuilder temp,char next){
       return temp.length()==0 || temp.charAt(temp.length()-1)!=next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reorganizeString("aab"));
        System.out.println(new Solution().reorganizeString("aaab"));
    }
}