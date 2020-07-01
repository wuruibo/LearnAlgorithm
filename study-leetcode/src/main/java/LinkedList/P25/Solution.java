package LinkedList.P25;

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
    private ListNode newHead;
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k==1 || head==null) {
            return head;
        }
        ListNode start=head,startBefore=new ListNode(0),end=head,nextEnd;
        startBefore.next=head;
        head=startBefore;
        int count=1;
        while (end!=null){
            end=end.next;
            nextEnd=(end==null?null:end.next);
            if (end!=null && ++count%k==0) {
                ListNode newTail=recursive(start,end);
                newTail.next=nextEnd;
                start=nextEnd;
                end=nextEnd;
                startBefore.next=newHead;
                startBefore=newTail;
                count=1;
            }
        }
        return head.next;
    }
    private ListNode recursive(ListNode first,ListNode second){
        if (first==second) {
            newHead=second;
            return second;
        }
        ListNode tail=recursive(first.next,second);
        tail.next=first;
        return first;
    }

    public static void main(String[] args) {
        ListNode node= ListNodeUtils.buildWithArray(new int[]{1});
        new Solution().reverseKGroup(node,2);
    }
}