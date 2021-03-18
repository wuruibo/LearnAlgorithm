package Tree.P331;

import java.util.LinkedList;

/**
 * @author yeqiaozhu.
 * @date 3/12/21
 */
public class StackSolution {
    public boolean isValidSerialization(String preorder) {
        //stack如果是数字直接push 如果两个#和一个数字 则pop并push一个#
        String[] strings=preorder.split(",");
        LinkedList<String> deque=new LinkedList<>();
        for(int i=0;i<strings.length;i++){
            String cur=strings[i];
            if(deque.size()<=1){
                deque.offer(cur);
            }else if(!cur.equals("#")){
                deque.offer(cur);
            }else{
                deque.offer(cur);
                int n=deque.size();
                while(n>=3 && deque.get(n-1).equals("#") && deque.get(n-2).equals("#")){
                    if(deque.get(n-3).equals("#")){
                        return false;
                    }else{
                        deque.pollLast();
                        deque.pollLast();
                        deque.pollLast();
                        deque.offer("#");
                        n=deque.size();
                    }
                }
            }
        }
        return deque.size()==1;
    }

    public static void main(String[] args) {
        System.out.println(new StackSolution().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
}
