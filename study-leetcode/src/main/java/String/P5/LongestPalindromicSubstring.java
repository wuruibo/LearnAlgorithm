package String.P5;

/**
 * 定义一个二维数组，booleans[i][j]中i表示子字符串的起点，j表示终点，boolean值记录是否为回文
 * 最大回文子串
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s ==null || s.length() ==0){
            return "";
        }else {
            int n=s.length();
            boolean[][] booleans= new boolean[n][n];
            String res="";
            for(int i=0;i<s.length();i++){

                for(int j=0;j<s.length()-i;j++){
                    booleans[j][j+i] = s.charAt(j) == s.charAt(j+i) && (i<2 || booleans[j+1][j+i-1]);

                    if(booleans[j][j+i] && i+1>res.length()){
                        res=s.substring(j,j+i+1);
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        String string="babad";
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(string));
    }
}
