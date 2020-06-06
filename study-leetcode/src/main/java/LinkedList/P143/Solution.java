package LinkedList.P143;

import LinkedList.AddTwoNumbers.ListNode;
import CommonUtils.ListNodeUtils;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 利用双端队列
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        //构造双端队列
        Deque<ListNode> deque= new LinkedList<>();
        ListNode temp=head;
        while (temp != null) {
            deque.offerLast(temp);
            temp=temp.next;
        }
        //从双端队列中取出
        ListNode newHead=new ListNode(0);
        newHead.next=head;

        ListNode current=newHead;

        while (deque.size()!=0){
            current.next=deque.pollFirst();
            current=current.next;

            current.next=deque.pollLast();
            current=current.next;
        }
        if (current!=null) {
            current.next=null;
        }
    }

    public static void main(String[] args) {
        int[] ints={1,2,3,4};
        ListNode listNode= ListNodeUtils.buildWithArray(ints);
        new Solution().reorderList(listNode);
    }
}