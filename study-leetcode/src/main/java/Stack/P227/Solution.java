package Stack.P227;

import java.util.*;

/**
 * Example 1:
 *
 * Input: "3+2*2"
 * Output: 7
 * Example 2:
 *
 * Input: " 3/2 "
 * Output: 1
 * Example 3:
 *
 * Input: " 3+5 / 2 "
 * Output: 5
 */
class Solution {

    Map<Character,Integer> operatorMap= new HashMap<>();
    {
        operatorMap.put('+',1);
        operatorMap.put('-',1);
        operatorMap.put('*',2);
        operatorMap.put('/',2);
    }
    public int calculate(String s) {
        //定义一个符号栈 + 数值栈
        Stack<Integer> digitStack=new Stack<>();
        Stack<Character> operatorStack=new Stack<>();

        //定义数字相加的临时字符串
        Integer temp=0;
        for (int i = 0; i < s.length(); i++) {
            Character cur=s.charAt(i);
            if (cur<='9' && cur>='0'){
                temp=temp*10+cur-'0';
            }else {
                //是空格直接忽略
                if (cur!=' ') {
                    digitStack.push(temp);
                    temp=0;
                    //判断当前操作符优先级是否小于栈顶操作符的优先级
                    while (!operatorStack.isEmpty() && operatorMap.get(cur)<=operatorMap.get(operatorStack.peek())){
                        //循环pop操作符和数值符 开始运算
                        operator(digitStack,operatorStack.pop());
                    }
                    operatorStack.push(cur);
                }
            }
            if (i==s.length()-1) {
                digitStack.push(temp);
            }
        }
        //将操作符栈和数值栈都pop到空
        while (!operatorStack.isEmpty()) {
            Character cur=operatorStack.pop();
            operator(digitStack,cur);
        }
        return digitStack.pop();
    }

    private void operator(Stack<Integer> digitStack,Character cur){
        //循环pop操作符和数值符 开始运算
        Integer second=digitStack.pop();
        Integer first=digitStack.pop();

        if (cur=='*') {
            digitStack.push(first*second);
        }else if(cur=='/'){
            digitStack.push(first/second);
        }else if(cur=='+'){
            digitStack.push(first+second);
        }else {
            digitStack.push(first-second);
        }
    }
    public static void main(String[] args) {
        /*System.out.println(new Solution().calculate("3+2*2"));
        System.out.println(new Solution().calculate("3/2"));*/
        System.out.println(new Solution().calculate(" 3+5 / 2 "));
        System.out.println(new Solution().calculate(" 3"));
        System.out.println(new Solution().calculate(" 3*10+1/2-20"));
        System.out.println(new Solution().calculate(" 3*101+11/2-20"));
        System.out.println(new Solution().calculate(" 0*1+1 "));
        System.out.println(new Solution().calculate(" 35+5 / 2 "));
        System.out.println(new Solution().calculate("14/3*2"));
        System.out.println((int) '+');
        System.out.println((int) '-');
        System.out.println((int) '*');
        System.out.println((int) '/');
    }
}