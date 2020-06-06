package Math.P67;

/**
 * add two binary String
 *
 */
class Solution {
    public String addBinary(String a, String b) {
        if (a==null || b==null || a.length()==0 || b.length()==0) {
            return "";
        }
        //定义进位变量 初始化为0
        int upInt=0;
        //确定长度大小
        String minString=a.length()<=b.length()?a:b;
        String maxString=a.length()>b.length()?a:b;

        //定义结果string
        StringBuilder result=new StringBuilder();
        //循环累加
        int tempSum;
        for (int i = 0; i <maxString.length(); i++) {
            //int distance=maxString.length()-minString.length();
            char maxChar=maxString.charAt(maxString.length()-1-i);
            if (i<minString.length()){
                //当前字符相加
                tempSum=maxChar+minString.charAt(minString.length()-i-1)+upInt-48*2;
            }else {
                //小字符串已经加完 默认补充零
                tempSum=maxChar+upInt-48;
            }
            //取余数
            result.append(tempSum & 1);
            //更新进位
            upInt=tempSum/2;
        }
        if (upInt==1) {result.append(1);}
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().addBinary("11","1"));
        //System.out.println(new Solution().addBinary("1010","1011"));
        //System.out.println(new Solution().addBinary("111","1"));
        System.out.println(new Solution().addBinary("1","111"));
    }
}