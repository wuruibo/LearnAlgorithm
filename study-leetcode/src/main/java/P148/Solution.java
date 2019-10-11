
package P148;

import AddTwoNumbers.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        //返回子问题
        ListNode sonHead=sortList(head.next);

        return null;
    }
}