package Stack.P150;

import java.util.Stack;

/**
 * 后缀表达式计算
 */
class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens==null || tokens.length==0) {
            return 0;
        }
        Stack<Integer> number=new Stack<>();
        //定义算符
        for (String token : tokens) {
            //判断token是否为数字
            if (isNumber(token)) {
                number.push(Integer.valueOf(token));
            }else {
                caculate(number,token);
            }
        }
        return number.peek();
    }
    private boolean isNumber(String token){
        for (int i = 0; i < token.length(); i++) {
            Character temp=token.charAt(i);
            if (temp>='0' && temp<='9') {
                return true;
            }
        }
        return false;
    }
    private void caculate(Stack<Integer> number,String operate){
        Integer second=number.pop();
        Integer first=number.pop();

        if (operate.equals("+")) {
            number.push(first+second);
        }else if(operate.equals("-")){
            number.push(first-second);
        }else if(operate.equals("*")){
            number.push(first*second);
        }else {
            number.push(first/second);
        }
    }

    public static void main(String[] args) {
        String[] strings={"2", "1", "+", "3", "*"};
        System.out.println(new Solution().evalRPN(strings));

        String[] strings1={"4", "13", "5", "/", "+"};
        System.out.println(new Solution().evalRPN(strings1));

        String[] strings2={"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new Solution().evalRPN(strings2));
    }
}