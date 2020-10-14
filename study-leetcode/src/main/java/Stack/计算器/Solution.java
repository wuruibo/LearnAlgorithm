package Stack.计算器;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 类比P224 算符优先 直接计算中缀表达式
 * 类比P150 根据后缀表达式 计算结果
 * 本题 先将中缀表达式转为后缀表达式 再根据后缀表达式计算结果
 */
class Solution {
    public int calculate(String s) {
        return calculate(toRPN(s));
    }

    private Queue<Character> toRPN(String s){
        s = s.replace(" ","");
        Stack<Character> stack = new Stack<>();
        Queue<Character> expQueue = new LinkedList<>();
        for(int i = 0;i<s.length();i++){

            while(i < s.length() && Character.isDigit(s.charAt(i))){
                expQueue.offer(s.charAt(i++));
            }
            expQueue.offer(' ');

            if(i < s.length() && isOperation(s.charAt(i))){
                if (!stack.isEmpty()) {
                    if (getPriority(s.charAt(i)) <= getPriority(stack.peek())) {
                        while (!stack.isEmpty() && (getPriority(s.charAt(i))) <= getPriority(stack.peek())) {
                            expQueue.offer(stack.pop());
                            expQueue.offer(' ');
                        }
                    }
                }
                stack.push(s.charAt(i));
            }
        }
        while(!stack.isEmpty()){
            expQueue.offer(stack.pop());
            expQueue.offer(' ');
        }
        return expQueue;
    }

    private int calculate(Queue<Character> expQueue){
        int len = expQueue.size();
        int value1, value2, res;
        Stack<Integer> valStack = new Stack<>();
        for(int i = 0;i<len;i++){
            char c = expQueue.poll();
            if(Character.isDigit(c)){
                int num = c-'0';
                int j = i;
                while(Character.isDigit(expQueue.peek())){
                    num = num * 10 + (expQueue.poll() - '0');
                    j++;
                }
                valStack.push(num);
                i = j;
            }else if(isOperation(c)){
                value2 = valStack.pop();
                value1 = valStack.pop();
                if(c == '+'){
                    res = value1 + value2;
                }else if(c == '-'){
                    res = value1 - value2;
                }else if(c == '*'){
                    res = value1 * value2;
                }else{
                    res = value1 / value2;
                }
                valStack.push(res);
            }
        }
        return valStack.pop();
    }
    
    
    private int getPriority(char c){
        switch(c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:return 0;
        }
    }

    private boolean isOperation(char c){
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static void main(String[] args) {
        System.out.println(new Solution().calculate("3+2*2"));
    }
}