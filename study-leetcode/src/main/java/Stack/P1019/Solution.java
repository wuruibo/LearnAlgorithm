package Stack.P1019;

import CommonUtils.ListNodeUtils;
import LinkedList.AddTwoNumbers.ListNode;

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 输入：[2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        //链表无法从后往前进行遍历 首先构造一个数组
        ListNode temp=head;
        List<Integer> list= new ArrayList<>();
        while (temp != null) {
            list.add(temp.val);
            temp=temp.next;
        }
        //从后往前遍历
        Deque<Integer> deque= new LinkedList<>();
        int[] result=new int[list.size()];
        for (int i = list.size() - 1; i >= 0; i--) {
            while (!deque.isEmpty() && deque.peekLast() <= list.get(i)) {
                deque.pollLast();
            }
            result[i]=deque.isEmpty()?0:deque.peekLast();
            deque.offerLast(list.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode listNode= ListNodeUtils.buildWithArray(new int[]{2,1,5});
        System.out.println(Arrays.toString(new Solution().nextLargerNodes(listNode)));

        ListNode listNode1= ListNodeUtils.buildWithArray(new int[]{2,7,4,3,5});
        System.out.println(Arrays.toString(new Solution().nextLargerNodes(listNode1)));

        ListNode listNode2= ListNodeUtils.buildWithArray(new int[]{});
        System.out.println(Arrays.toString(new Solution().nextLargerNodes(listNode2)));
    }
}