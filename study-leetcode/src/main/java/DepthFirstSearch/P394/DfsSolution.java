package DepthFirstSearch.P394;

import java.util.Deque;
import java.util.LinkedList;

public class DfsSolution {
    public String decodeString(String s) {
        return dfs(s);
    }
    private String dfs(String s){
        //如果碰到非数字字符就直接相加
        StringBuilder result=new StringBuilder();

        int digit=0;
        for (int i = 0; i < s.length();) {
            //如果已经有数字并且接下来不是数字 那么继续往下进行递归
            if (digit!=0 && s.charAt(i)=='['){
                //开始收集递归字符串
                i++;
                StringBuilder temp=new StringBuilder();
                Deque<Character> stack= new LinkedList<>();
                stack.offer('[');
                while (!stack.isEmpty()) {
                    if (s.charAt(i)=='[') {
                        stack.offerLast('[');
                    }
                    if (s.charAt(i)==']') {
                        stack.pollLast();
                    }
                    temp.append(s.charAt(i));
                    i++;
                }
                temp.deleteCharAt(temp.length()-1);
                String subResult=dfs(temp.toString());
                //digit进行相乘
                for (int k = 0; k < digit; k++) {
                    result.append(subResult);
                }
                digit=0;
            }else if (isDigit(s.charAt(i))) {
                digit*=10;
                digit+=(s.charAt(i++)-'0');
            }else {
                result.append(s.charAt(i++));
            }
        }
        return result.toString();
    }
    private boolean isDigit(char c){
        return c-'0'>=0 && c-'0'<=9;
    }

    public static void main(String[] args) {
        System.out.println(new DfsSolution().decodeString("3[a]2[bc]"));
        System.out.println(new DfsSolution().decodeString("3[a2[a]]"));
        System.out.println(new DfsSolution().decodeString("3[a2[ab1[abc]]]"));
    }
}
