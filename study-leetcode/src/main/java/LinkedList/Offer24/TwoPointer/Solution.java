package LinkedList.Offer24.TwoPointer;

import CommonUtils.ListNodeUtils;
import LinkedList.AddTwoNumbers.ListNode;

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
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode listNode= ListNodeUtils.buildWithArray(new int[]{1,2,3,4,5});
        String a="A-00-9000";
        String c=a.replaceAll("-","");
        System.out.println(c);
        new Solution().reverseList(listNode);
    }
}