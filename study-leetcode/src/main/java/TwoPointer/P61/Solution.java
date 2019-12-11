package TwoPointer.P61;

import LinkedList.AddTwoNumbers.ListNode;
import CommonUtils.ListNodeUtils;

/**
 * 2 pointer 定位到两个链表的头部
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null) {
            return null;
        }
        ListNode partHead=head,preHead=head,newHead;
        //计算链表的长度
        int length=0;
        while (partHead!=null){
            partHead=partHead.next;
            length++;
        }
        partHead=head;

        int time=length-k%length;
        //将partHead定位到新起点的位置
        while (time > 0) {
            preHead=partHead;
            partHead=partHead.next;
            time--;
        }
        if (partHead==null) {return head;}
        //preHead可以指向空，实现分割
        preHead.next=null;
        //改变指向
        newHead=partHead;
        while (partHead.next!=null){partHead=partHead.next;}
        partHead.next=head;

        return newHead;
    }

    public static void main(String[] args) {
        int[] ints={1,2,3,4,5};
        ListNode listNode=ListNodeUtils.buildWithArray(ints);
        new Solution().rotateRight(listNode,5);

        int[] ints1={0,1,2};
        ListNode listNode1=ListNodeUtils.buildWithArray(ints1);
        new Solution().rotateRight(listNode1,0);
    }
}