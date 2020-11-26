package String.P557;

import java.util.Arrays;

/**
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 */
class Solution {
    public String reverseWords(String s) {
        return Arrays.stream(s.split(" ")).map(str->{
            StringBuilder temp=new StringBuilder();
            for (int i = str.length()-1; i >= 0; i--) {
                temp.append(str.charAt(i));
            }
            return temp.toString();
        }).reduce((a,b)->a+" "+b).get();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("Let's take LeetCode contest"));
    }
}