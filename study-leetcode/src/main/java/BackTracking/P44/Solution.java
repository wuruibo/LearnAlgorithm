package BackTracking.P44;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 * 说明:
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 *
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 */
class Solution {
    private final char one='?';
    private final char all='*';
    private Map<String,Boolean> dpMap= new HashMap<>();
    public boolean isMatch(String s, String p) {
        return dfs(0,s,p,0);
    }
    private boolean dfs(int si,String s,String p,int pi){
        String key=si+"-"+pi;
        if (dpMap.containsKey(key)) {
            return dpMap.get(key);
        }
        if (si==s.length() && pi==p.length()) {
            dpMap.put(key,true);
            return true;
        }
        Boolean result=null;
        if (pi<p.length() && p.charAt(pi)==all){
            for (int i = si; i <= s.length(); i++) {
                if (dfs(i,s,p,pi+1)) {
                    result=true;
                }
            }
        }else if (pi<p.length() && p.charAt(pi)==one){
            result=dfs(si+1,s,p,pi+1);
        }else if (pi<p.length() && si<s.length() && s.charAt(si)==p.charAt(pi)) {
            result=dfs(si+1,s,p,pi+1);
        }
        if (result==null) {
            result=false;
        }
        dpMap.put(key,result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("abefcdgiescdfimde" , "ab*cd?i*de"));
        System.out.println(new Solution().isMatch("" , "******"));
        System.out.println(new Solution().isMatch("aa", "a"));
        System.out.println(new Solution().isMatch("aa", "*"));
        System.out.println(new Solution().isMatch("cb", "?a"));
        System.out.println(new Solution().isMatch("adceb", "*a*b"));
        System.out.println(new Solution().isMatch("acdcb", "a*c?b"));
    }
}