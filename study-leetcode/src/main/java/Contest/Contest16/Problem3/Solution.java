package Contest.Contest16.Problem3;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 两个栈分别将"("和"*"的序号压入栈中，每次遇到右括号，首先检测左括号栈中是否为空，不为空则弹出元素，否则弹出star栈。
 * 最后考虑left和star栈可能存在元素，判断此时栈中元素的序号大小。
 * 如果left栈中的序号大于star中的则表明 存在"*("此种情况，直接false
 */
class Solution {
    public boolean checkValidString(String s) {
        //step1 定义两个栈 一个存'('
        //另一个存'*'
        Deque<Integer> left= new ArrayDeque<>();
        Deque<Integer> stars=new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='(') {
                left.offerLast(i);
            }else if(s.charAt(i)=='*'){
                stars.offerLast(i);
            }else {
                if (!left.isEmpty()) {
                    left.pollLast();
                }else if(!stars.isEmpty()){
                    stars.pollLast();
                }else {
                    return false;
                }
            }
        }
        while(!left.isEmpty() && !stars.isEmpty()){
            if(left.peekLast()>stars.peekLast()) return false;
            left.pollLast();
            stars.pollLast();
        }
        return left.isEmpty();
    }
}