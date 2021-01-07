package Contest.Contest45.Problem1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 输入：students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
 * 输出：3
 */
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        //构造双端队列
        Deque<Integer> deque= new LinkedList<>();
        for (int i = 0; i < students.length; i++) {
            deque.offerLast(students[i]);
        }
        for (int i = 0; i < sandwiches.length; i++) {
            int size=deque.size(),count=0;
            while (count<size && deque.peekFirst() != sandwiches[i]) {
                Integer pre=deque.pollFirst();
                deque.offerLast(pre);
                count++;
            }
            if (count==size) {
                return count;
            }
            deque.pollFirst();
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countStudents(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1}));
        System.out.println(new Solution().countStudents(new int[]{0,0,0,1,0,1,1,1,1,0,1}, new int[]{0,0,0,1,0,0,0,0,0,1,0}));
        System.out.println(new Solution().countStudents(new int[]{1,1,0,0}, new int[]{0,1,0,1}));
    }
}