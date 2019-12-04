package LinkedList.P82;

import AddTwoNumbers.ListNode;
import CommonUtils.ListNodeUtils;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * Example 1:
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 *
 * Input: 1->1->1->2->3
 * Output: 2->3
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null) {
            return null;
        }
        //定义two pointer and pre slow pointer
        ListNode slow=head,fast=head.next,preSlow=null;
        boolean flag=false;
        while (slow != null) {
            if (fast!=null && slow.val==fast.val) {
                fast=fast.next;
                flag=true;
            }else {
                if (flag) {
                    if (preSlow==null) {
                        head=fast;
                    }else {
                        preSlow.next=fast;
                    }
                    flag=false;
                    slow=fast;
                }else {
                    preSlow = slow;
                    slow = slow.next;
                }
                if (fast != null) fast = fast.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] ints1={1,1,2,3,3};
        ListNode listNode1= ListNodeUtils.buildWithArray(ints1);
        new Solution().deleteDuplicates(listNode1);

        int[] ints2={1,1};
        ListNode listNode2= ListNodeUtils.buildWithArray(ints2);
        new Solution().deleteDuplicates(listNode2);
    }
}