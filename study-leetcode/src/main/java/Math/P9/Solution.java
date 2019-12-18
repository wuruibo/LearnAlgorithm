package Math.P9;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }
        Deque<Integer> deque= new LinkedList<>();
        while (x!=0){
            deque.push(x%10);
            x/=10;
        }

        while (deque.size()>0 && deque.peekFirst()==deque.peekLast()){deque.pollFirst();deque.pollLast();}

        return deque.size()>1?false:true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(121));
        System.out.println(new Solution().isPalindrome(-121));
        System.out.println(new Solution().isPalindrome(0));
        System.out.println(new Solution().isPalindrome(12211));
        System.out.println(new Solution().isPalindrome(1221));
    }
}