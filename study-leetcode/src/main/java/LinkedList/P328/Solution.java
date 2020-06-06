package LinkedList.P328;

import CommonUtils.ListNodeUtils;
import LinkedList.AddTwoNumbers.ListNode;

/**
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * Example 2:
 *
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 * Note:
 *
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 *
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head==null) {
            return null;
        }
        ListNode odd=head,even=head.next,evenHead=head.next;
        while (odd!=null && odd.next!=null && odd.next.next!=null){
            odd.next=odd.next.next;
            odd=odd.next;
            if(even!=null && even.next!=null){
                even.next=even.next.next;
                even=even.next;
            }
        }
        if (even!=null) {even.next=null;}
        odd.next=evenHead;

        return head;
    }

    public static void main(String[] args) {
        int[] ints={1};
        ListNode listNode= ListNodeUtils.buildWithArray(ints);
        new Solution().oddEvenList(listNode);
    }
}