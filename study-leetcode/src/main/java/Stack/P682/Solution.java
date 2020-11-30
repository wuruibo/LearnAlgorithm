package Stack.P682;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int calPoints(String[] ops) {
        Deque<Integer> deque= new LinkedList<>();
        int i=0;
        while (i < ops.length) {
            String cur=ops[i];
            if ("C".equals(cur) && !deque.isEmpty()) {
                deque.pollLast();
            }else if("D".equals(cur) && !deque.isEmpty()){
                Integer pre=deque.peekLast();
                deque.offerLast(pre*2);
            }else if ("+".equals(cur) && !deque.isEmpty()){
                Integer pre=deque.pollLast();
                Integer prev=deque.isEmpty()?0:deque.peekLast();

                Integer next=prev+pre;
                deque.offerLast(pre);
                deque.offerLast(next);
            }else {
                deque.offerLast(Integer.parseInt(ops[i]));
            }
            i++;
        }
        int result=0;
        while (!deque.isEmpty()) {
            result+=deque.pollLast();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().calPoints(new String[]{"5", "2", "C", "D", "+"}));
        System.out.println(new Solution().calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }
}