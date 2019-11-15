package P459;

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        //定义step
        for (int step = 1; step < s.length(); step++) {
            if (s.length()%step==0) {
                //定义一个StringBuilder构造当前子串构成的字符串
                StringBuilder stringBuilder=new StringBuilder();
                int begin=0;
                String sub=s.substring(begin,begin+step);
                while ((begin+step)<=s.length()){
                    stringBuilder.append(sub);
                    begin+=step;
                }
                if (stringBuilder.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().repeatedSubstringPattern("ababba"));
        System.out.println(new Solution().repeatedSubstringPattern("abab"));
        System.out.println(new Solution().repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(new Solution().repeatedSubstringPattern("aba"));
    }
}