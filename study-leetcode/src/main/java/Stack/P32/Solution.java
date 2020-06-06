package Stack.P32;

import java.util.Stack;

// TODO: 2019-12-18 照着抄了栈的写法 还有dp的写法下次写一下dp的状态转移方程
class Solution {
    public int longestValidParentheses(String s) {
        int result=0,max=0;
        if (s==null || s.length()==0) {
            return result;
        }
        Stack<Character> stack=new Stack<>();
        stack.push('#');
        for (int i = 0; i < s.length(); i++) {
            Character character=s.charAt(i);
            if (character=='(') {
                stack.push(character);
            }else {
                if (stack.peek()=='(' && character==')'){
                    stack.pop();
                    result+=2;
                    max=max<result?result:max;
                }else {
                    result=0;
                    stack.push(character);
                }
            }
            /*if (stack.peek()=='(' && character==')'){
                stack.pop();
                result+=2;
                max=max<result?result:max;
            }else {
                if (character!='(') {
                    result=0;
                }
                stack.push(character);
            }*/
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses("(()"));
        System.out.println(new Solution().longestValidParentheses(")()())"));
        System.out.println(new Solution().longestValidParentheses("()(()"));
    }
}