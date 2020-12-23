package Contest.Contest43.Problem1;

class Solution {
    public String reformatNumber(String number) {
        char[] chars=number.toCharArray();
        StringBuilder result=new StringBuilder();
        for (int i = 0,j=0; i < chars.length; i++) {
            if (chars[i]!=' ' && chars[i]!='-'){
                result.append(chars[i]);
                if (++j%3==0) {
                    result.append("-");
                }
            }
        }
        //针对剩余是1的特殊处理
        int j = result.length()-1;
        if (result.charAt(j)=='-') {
            result.deleteCharAt(j);
        }
        if (j-1>=0 && result.charAt(j-1)=='-') {
            result.setCharAt(j-1,result.charAt(j-2));
            result.setCharAt(j-2,'-');
        }
        //统计result
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reformatNumber("1-23-45 6"));
        System.out.println(new Solution().reformatNumber("1"));
        System.out.println(new Solution().reformatNumber("1-23-45 678"));
        System.out.println(new Solution().reformatNumber("123 4-567"));
        System.out.println(new Solution().reformatNumber("123 4-5678"));
    }
}