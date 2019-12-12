package Stack.P224;

import java.util.Stack;

/**
 * Example 1:
 *
 * Input: "1 + 1"
 * Output: 2
 * Example 2:
 *
 * Input: " 2-1 + 2 "
 * Output: 3
 * Example 3:
 *
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 */
class Solution {
    //定义算符优先表 这里一共四种运算符号
    private String operators="()+-#";
    //定义算符优先级 二位数组
    private char[][] operatorArray=
            {{'<','=','<','<','>'},
            {'>',' ','>','>','>'},
            {'<','>','>','>','>'},
            {'<','>','>','>','>'},
            {'<',' ','<','<','='}};
    private boolean flag=false;//标记前面是否出现过数字
    public int calculate(String s) {
        //定义符号栈+数值栈
        Stack<Character> operator = new Stack<>();
        Stack<Integer> number = new Stack<>();

        //算符栈#作为结束符
        operator.push('#');
        s=s.concat("#");
        //循环
        Integer temp = 0;
        int index=0;
        Character cur=s.charAt(index);

        while (cur!='#' || operator.peek()!='#'){
            if (cur==' ') {
                cur=s.charAt(++index);
            }else if (cur>='0' && cur<='9'){
                temp = temp * 10 + cur - '0';
                flag=true;
                cur=s.charAt(++index);
            }else {
                if (flag) {number.push(temp);temp=0;flag=false;}
                switch (preCode(operator.peek(),cur)){
                    //当前运算符优先级较大，则直接入栈，置于栈顶(优先级高需先计算
                    case '<': operator.push(cur);cur=s.charAt(++index);break;
                    //弹出左括号
                    case '=': operator.pop();cur=s.charAt(++index);break;
                    //进行操作符运算
                    case '>': operator(number,operator.pop());break;
                }
            }
        }
        if (flag==true) {number.push(temp);}
        return number.pop();
    }

    private void operator(Stack<Integer> digitStack, Character cur) {
        //循环pop操作符和数值符 开始运算
        Integer second=digitStack.pop();
        Integer first=digitStack.pop();
        if (cur=='+') {
            digitStack.push(first+second);
        }else {
            digitStack.push(first-second);
        }
    }
    private char preCode(char first,char second){
        return operatorArray[operators.indexOf(first)][operators.indexOf(second)];
    }
    public static void main(String[] args) {
        System.out.println(new Solution().calculate("1 + 1"));
        System.out.println(new Solution().calculate("0"));
        System.out.println(new Solution().calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(new Solution().calculate("(7)-(0)+(4)"));
        System.out.println(new Solution().calculate(" 2-1 + 2 "));
    }
}