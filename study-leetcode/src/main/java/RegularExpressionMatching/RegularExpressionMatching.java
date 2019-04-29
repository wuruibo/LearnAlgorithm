package RegularExpressionMatching;

/**
 *
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 *
 * Test Case:
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 *
 *
 * @autor yeqiaozhu.
 * @date 2019-04-25
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if(s.length() ==0 && p.length()==0) {
            return true;
        }else  if(s.length()==0 || p.length() ==0){
            return false;
        }else {
            char[] sChars=s.toCharArray();
            char[] pChars=p.toCharArray();
            for(int i=0;i<s.length();){
                if(sChars[i] != pChars[i]){
                    //第一次比较不相等，走转换器转换
                    if(sChars[i] == pChars[i-1] && pChars[i] == '*'){

                    }else if(pChars[i]== '.'){
                        pChars[i] = sChars[i];
                    }else {
                        return false;
                    }
                }

            }
        }
        return true;
    }

    private void defineReplace(){

    }

    public static void main(String[] args) {
        System.out.println("".equals(" "));
    }

}
