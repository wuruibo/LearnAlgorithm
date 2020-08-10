package Contest.Contest24.Problem3;

class Solution {
    public String makeGood(String s) {
        for (int i = 0; i < s.length()-1; i++) {
            if (different(s.charAt(i),s.charAt(i+1))) {
                s=copyString(s,i);
                return makeGood(s);
            }
        }
        return s;
    }
    private boolean different(Character left,Character right){
        boolean a=left>='a' && left<='z' && right>='A' && right<='Z';
        boolean b=right>='a' && right<='z' && left>='A' && left<='Z';
        return (a || b) && Character.toUpperCase(left)==Character.toUpperCase(right);
    }
    private String copyString(String string,int index){
        StringBuilder result=new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (index!=i && index!=i-1) {
                result.append(string.charAt(i));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().makeGood("leEeetcode"));
        System.out.println(new Solution().makeGood("abBAcC"));
        System.out.println(new Solution().makeGood("s"));
    }
}