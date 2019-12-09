package LinkedList.P147;

import AddTwoNumbers.ListNode;
import CommonUtils.ListNodeUtils;

/**
 * 不能二分只能n2
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// TODO: 2019-12-06 这道题能不能用归并 归并的时间复杂度nlogn
class Solution {
    public ListNode insertionSortList(ListNode head) {
        //定义newHead
        ListNode newHead=new ListNode(Integer.MIN_VALUE);
        //待排序下标
        ListNode temp=head;
        while (temp!=null){
            //定义已排序下标
            ListNode order=newHead,nextTemp=temp.next;
            /*这段代码可以简化成将if的部分放到while里面，找到位置后进行if里面的操作
            while (order!=null){
                if (order.next==null || order.next.val>=temp.val) {
                    temp.next=order.next;
                    order.next=temp;
                    break;
                }
                order=order.next;
            }*/
            while (order.next!=null && order.next.val<temp.val){order=order.next;}
            temp.next=order.next;
            order.next=temp;

            temp=nextTemp;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        int[] ints={4,2,1,3};
        ListNode listNode=ListNodeUtils.buildWithArray(ints);
        new Solution().insertionSortList(listNode);

        int[] ints1={-1,5,3,4,0};
        ListNode listNode1=ListNodeUtils.buildWithArray(ints1);
        new Solution().insertionSortList(listNode1);
    }
}