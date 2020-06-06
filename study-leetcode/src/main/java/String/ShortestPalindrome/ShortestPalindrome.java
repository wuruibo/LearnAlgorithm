package String.ShortestPalindrome;

/**
 * Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it.
 * Find and return the shortest palindrome you can find by performing this transformation.
 * @autor yeqiaozhu.
 * @date 2019-05-02
 */
public class ShortestPalindrome {
    /**
     * 前后遍历
     * 时间复杂度 n2
     * 空间复杂度 n
     *
     * @param s
     * @return
     */
    public String shortestPalindrome(String s) {
        boolean fromBreak = false;
        int length=s.length();
        for(int j=length-1;j>=0;j--){
            if(s.charAt(0) == s.charAt(j)) {
                int indexRight= j;
                int indexLeft=0;
                while (indexLeft < indexRight){
                    indexLeft ++;
                    indexRight --;
                    if(s.charAt(indexLeft) != s.charAt(indexRight)){
                        fromBreak = true;
                        break;
                    }
                }
                if(fromBreak){
                    fromBreak = false;
                }else {
                    int index = length-1;
                    StringBuilder stringBuilder =new StringBuilder();
                    while (index > j){
                        stringBuilder.append(s.charAt(index));
                        index--;
                    }
                    return stringBuilder.append(s).toString();
                }
            }
        }
        return "";
    }

    /**
     * 使用bmp算法
     * @param s
     * @return
     */
    public String shortestPalindromeUsingBMP(String s) {
        return  null;
    }
        public static void main(String[] args) {
        System.out.println(new ShortestPalindrome().shortestPalindrome("a"));
    }
}
