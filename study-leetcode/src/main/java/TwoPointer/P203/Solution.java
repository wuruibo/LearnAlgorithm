package TwoPointer.P203;

import AddTwoNumbers.ListNode;
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre=null,cur=head;

        while (cur != null) {
            if (cur.val!=val) {
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
        return head;
    }

    public static void main(String[] args) {
        int[] ints={1,2,6,3,4,5,6};
        ListNode listNode= ListNodeUtils.buildWithArray(ints);
        new Solution().removeElements(listNode,1);
    }
}