package Stack.单调栈.P402;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    private final Character zero='0';
    public String removeKdigits(String num, int k) {
        Deque<Character> deque= new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            while (!deque.isEmpty() && deque.peekLast() > num.charAt(i) && k>0) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(num.charAt(i));
        }
        //重新拼接字符串
        while (k!=0){
            deque.pollLast();
            k--;
        }
        //将队列中的字符转换为数值
        while (!deque.isEmpty() && zero.equals(deque.peekFirst())) {
            deque.pollFirst();
        }
        return deque.isEmpty()?"0":Arrays.stream(deque.toArray()).reduce((a, b) -> a + "" + b).get().toString();
    }

    public static void main(String[] args) {
        Deque<Character> deque=new LinkedList<>();
        deque.offerLast('0');
        deque.offerLast('1');
        deque.offerLast('2');
        System.out.println(Arrays.stream(deque.toArray()).reduce((a, b) -> a + "" + b).get().toString());
        System.out.println(deque.toString());

        System.out.println(new Solution().removeKdigits("11234211", 5));
        System.out.println(new Solution().removeKdigits("10200", 1));
        System.out.println(new Solution().removeKdigits("10", 2));
    }
}