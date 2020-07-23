package Contest.Contest14;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean backspaceCompare(String S, String T) {
        String left=popStack(S);
        String right=popStack(T);
        return left.equals(right);
    }
    private String popStack(String input){
        char[] chars=input.toCharArray();
        Deque<Character> deque= new ArrayDeque<>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i]!='#') {
                deque.offerLast(chars[i]);
            }else if(!deque.isEmpty()){
                deque.pollLast();
            }
        }
        return deque.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().backspaceCompare("ab#c", "ad#c"));
        System.out.println(new Solution().backspaceCompare("ab##", "ad#c"));
        System.out.println(new Solution().backspaceCompare("a##c", "#a#c"));
        System.out.println(new Solution().backspaceCompare("a#c", "b"));
    }
}