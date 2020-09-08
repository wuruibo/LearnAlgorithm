package Contest.Contest29.Problem1;

class Solution {
    public String modifyString(String s) {
        StringBuilder result=new StringBuilder();
        char[] chars=s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (s.charAt(i)=='?') {
                chars[i]=findNext(i,chars);
            }
            result.append(chars[i]);
        }
        return result.toString();
    }
    private char findNext(int i,char[] chars){
        Integer number=26;
        char left=i==0?'A':chars[i-1];
        char right=i==chars.length-1?'A':chars[i+1];
        //循环
        for (int j = 0; j < number; j++) {
            char current= (char) ('a'+j);
            if (current!=left && current!=right) {
                return current;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(new Solution().modifyString("?zs"));
        System.out.println(new Solution().modifyString("ubv?w"));
        System.out.println(new Solution().modifyString("j?qg??b"));
        System.out.println(new Solution().modifyString("??yw?ipkj?"));
    }
}