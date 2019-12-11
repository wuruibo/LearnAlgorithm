package LinkedList.P83;

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
    public ListNode deleteDuplicates(ListNode head) {
        //定义双指针
        ListNode slow=head,fast=head;

        while (slow!=null && fast!=null){
            if (slow.val==fast.val) {
                slow.next=fast.next;
                fast=fast.next;
            }else {
                slow=slow.next;
                fast=fast.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] ints1={1,1,2,3,3};
        ListNode listNode1= ListNodeUtils.buildWithArray(ints1);
        new Solution().deleteDuplicates(listNode1);

        int[] ints2={1};
        ListNode listNode2= ListNodeUtils.buildWithArray(ints2);
        new Solution().deleteDuplicates(listNode2);
    }
}