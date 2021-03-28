package Stack.P71;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public String simplifyPath(String path) {
        Deque<String> deque=new LinkedList<>();
        for (int i = 1; i < path.length(); i++) {
            StringBuilder next=new StringBuilder();
            while (i < path.length() && path.charAt(i)!='/') {
                next.append(path.charAt(i++));
            }
            next.append("/");
            String current=next.toString();
            if (!current.equals("./") && !current.equals("/")) {
                if (current.equals("../") && !deque.isEmpty()){
                    deque.poll();
                }else if (!current.equals("../")){
                    deque.offer(current);
                }
            }
        }
        StringBuilder result=new StringBuilder("/");
        while(!deque.isEmpty()){
            result.append(deque.pollFirst());
        }
        return result.length()==1?result.toString():result.substring(0,result.length()-1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("/home/"));
        System.out.println(new Solution().simplifyPath("//"));
        System.out.println(new Solution().simplifyPath("/../"));
        System.out.println(new Solution().simplifyPath("/../../"));
        System.out.println(new Solution().simplifyPath("/home//too"));
    }
}