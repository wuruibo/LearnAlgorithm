package WaitingCollect.P234;

import LinkedList.AddTwoNumbers.ListNode;
import CommonUtils.ListNodeUtils;

/**
 * 找到链表的中点
 * 可以用快慢指针
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private ListNode reverse;
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        //找到中间的位置啦
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //然后将后边的复制出来，改变指针的指向形成堆成
        ListNode halfPart=new ListNode(slow.val);
        halfPart.next=slow.next;
        slow.next=null;

        //两个链表构造完成将后半个链表旋转
        reverseListNode(halfPart);

        //旋转完了之后遍历进行比较
        while (reverse!=null){
            if (reverse.val!=head.val) {
                return false;
            }
            head=head.next;
            reverse=reverse.next;
        }
        return true;
    }

    public ListNode reverseListNode(ListNode start){
        if (start.next==null) {
            reverse=start;
            return reverse;
        }
        ListNode subList=reverseListNode(start.next);
        subList.next=start;
        start.next=null;
        return start;
    }

    public static void main(String[] args) {
        int[] ints={1,2,2,1};
        ListNode head=ListNodeUtils.buildWithArray(ints);

        new Solution().isPalindrome(head);
    }
}