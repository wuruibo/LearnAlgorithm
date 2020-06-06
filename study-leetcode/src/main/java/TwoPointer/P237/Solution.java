package TwoPointer.P237;

import LinkedList.AddTwoNumbers.ListNode;
import CommonUtils.ListNodeUtils;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private ListNode head;
    public Solution() {
        int[] ints={4,5,1,9};
        head= ListNodeUtils.buildWithArray(ints);
    }

    public void deleteNode(ListNode node) {
        ListNode pre=null,cur=head;

        while (cur != null) {
            if (cur.val!=node.val) {
                pre=cur;
            }else {
                if (pre==null) {
                    head=cur.next;
                }else {
                    pre.next=cur.next;
                }
            }
            cur=cur.next;
        }
    }
}