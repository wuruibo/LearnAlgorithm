package Stack.P32;

import java.util.Stack;

/**
 * Example 1:
 *
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 *
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 *
 * Input: "()(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 *
 * 这种方式还是很难理解
 *
 * @autor yeqiaozhu.
 * @date 2019-12-18
 */
public class UsingStack {
    public int longestValidParentheses(String s) {
        int max=0;
        if (s==null || s.length()==0) {
            return max;
        }
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            Character character=s.charAt(i);
            //碰到左括号
            if (character=='(') {
                stack.push(i);
            }else {
                //碰到右括号直接弹出
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }else {
                    max=Math.max(max,i-stack.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new UsingStack().longestValidParentheses("(()"));
        System.out.println(new UsingStack().longestValidParentheses("))))))"));
        System.out.println(new UsingStack().longestValidParentheses("(())"));
        System.out.println(new UsingStack().longestValidParentheses(")()())"));
        System.out.println(new UsingStack().longestValidParentheses("()(()"));
    }
}