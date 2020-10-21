package Contest.Contest35.Problem1;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int maxDepth(String s) {
        Deque<Character> deque= new ArrayDeque<>();
        int maxDepth=0;
        for (int i = 0; i < s.length(); i++) {
            Character current=s.charAt(i);
            if (indexOfCircle(current)) {
                if (deque.isEmpty()) {
                    deque.offerLast(current);
                }else if(deque.peekLast().equals('(') && current.equals(')')){
                    deque.pollLast();
                }else {
                    deque.offerLast(current);
                }
            }
            maxDepth=Math.max(maxDepth,deque.size());
        }
        return maxDepth;
    }
    private boolean indexOfCircle(Character character){
        return character.equals('(') || character.equals(')');
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(new Solution().maxDepth("(1)+((2))+(((3)))"));
        System.out.println(new Solution().maxDepth("1+(2*3)/(2-1)"));
        System.out.println(new Solution().maxDepth("1"));
    }
}