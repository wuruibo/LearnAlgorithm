
package LinkedList.P148;

import LinkedList.AddTwoNumbers.ListNode;
import CommonUtils.ListNodeUtils;

/**
 * 归并排序
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public ListNode sortList(ListNode head) {
        if (head==null ||head.next == null) {
            return head;
        }
        //定位到中间位置
        ListNode fast=head;
        ListNode front;
        ListNode slow=head;
        while (true){
            front=slow;
            slow=slow.next;
            fast=fast.next.next;
            if (fast==null || fast.next==null ) {
                front.next=null;
                break;
            }
        }
        //返回子问题
        ListNode leftSort=sortList(head);
        ListNode rightSort=sortList(slow);

        return mergeTwoLinkedList(leftSort,rightSort);
    }

    public ListNode mergeTwoLinkedList(ListNode leftSort,ListNode rightSort){
        ListNode newHead=new ListNode(0);
        ListNode current=newHead;
        while (leftSort!=null || rightSort!=null){
            if (leftSort==null) {
                current.next=rightSort;
                break;
            }else if(rightSort==null){
                current.next=leftSort;
                break;
            }else {
                if ((leftSort.val<rightSort.val)) {
                    ListNode listNode=new ListNode(leftSort.val);
                    current.next=listNode;
                    current=listNode;
                    leftSort=leftSort.next;
                }else {
                    ListNode listNode=new ListNode(rightSort.val);
                    current.next=listNode;
                    current=listNode;
                    rightSort=rightSort.next;
                }
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        int[] ints={4,2,1,3};
        int[] ints1={-1,5,3,4,0};
        ListNode listNode= ListNodeUtils.buildWithArray(ints);
        ListNode testst1= ListNodeUtils.buildWithArray(ints1);

        new Solution().sortList(listNode);
        ListNodeUtils.printListNodes(new Solution().sortList(testst1));
        ListNodeUtils.printListNodes(null);
    }
}