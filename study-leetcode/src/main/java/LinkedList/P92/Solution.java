package LinkedList.P92;

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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head==null) {return null;}
        //一边遍历到位置
        ListNode newHead=null,newTail=null,reHead=null,reTail=null,preTemp=null,temp=head;

        while (temp != null) {
            if (--m==0) {newHead=preTemp;reHead=temp;};
            if (--n==0) {newTail=temp.next;reTail=temp;}

            preTemp=temp;
            temp=temp.next;
        }
        //reverse指定位置的字符串
        reverseMn(reHead,reTail);
        if (newHead==null) {head=reTail;}
        else {
            newHead.next=reTail;
        }
        reHead.next=newTail;

        return head;
    }
    public ListNode reverseMn(ListNode head,ListNode tail){
        if (head==tail) {
            return tail;
        }
        ListNode subHead=reverseMn(head.next,tail);
        subHead.next=head;

        return head;
    }

    public static void main(String[] args) {
        int[] ints={1,2,3,4,5};
        ListNode listNode= ListNodeUtils.buildWithArray(ints);
        new Solution().reverseBetween(listNode,5,5);

        int[] ints1={};
        ListNode listNode1= ListNodeUtils.buildWithArray(ints1);
        new Solution().reverseBetween(listNode1,1,4);
    }
}