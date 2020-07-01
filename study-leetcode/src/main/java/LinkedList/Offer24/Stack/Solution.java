package LinkedList.Offer24.Stack;

import CommonUtils.ListNodeUtils;
import LinkedList.AddTwoNumbers.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        Deque<ListNode> deque= new ArrayDeque<>();
        while (head!=null) {
            deque.offerLast(head);
            ListNode before=head;
            head=head.next;
            before.next=null;
        }
        ListNode newHead= new ListNode(0),tail=newHead;
        while (!deque.isEmpty()) {
            ListNode current=deque.pollLast();
            tail.next=current;
            tail=tail.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode= ListNodeUtils.buildWithArray(new int[]{1,2,3,4,5});
        new Solution().reverseList(listNode);
    }
}