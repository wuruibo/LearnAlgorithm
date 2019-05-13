package LinkedList.LinkedListCircle;

import AddTwoNumbers.ListNode;
import CommonUtils.ListNodeUtils;

import java.util.HashSet;

/**
 * @autor yeqiaozhu.
 * @date 2019-05-10
 */
public class LinkedListCircle {
    private HashSet<ListNode> hashSet=new HashSet<>();
    public ListNode detectCycle(ListNode head) {
        while (head!= null){
            if(hashSet.contains(head)){
                return head;
            }else {
                hashSet.add(head);
            }
            head = head.next;
        }
        return null;
    }
    public ListNode detectCycleUsingPointer(ListNode head){
        if(head ==null || head.next == null || head.next.next ==null){
            return null;
        }
        ListNode pointer1=head.next;
        ListNode pointer2=head.next.next;
        //step1:找出环的位置
        while (pointer1!=pointer2){
            if(pointer2 ==null || pointer2.next ==null){
                return null;
            }
            pointer2 =pointer2.next.next;
            pointer1 = pointer1.next;
        }
        //step2:重新开始一遍扫描环
        while(head != pointer1){
            head=head.next;
            pointer1=pointer1.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode=ListNodeUtils.createListNode(5,1);
        ListNode tempListNode=listNode;
        while (tempListNode.next !=null){
            tempListNode = tempListNode.next;
        }
        tempListNode.next=listNode.next;
        ListNode newListNode=new LinkedListCircle().detectCycle(listNode);
        ListNode newListNodePointer=new LinkedListCircle().detectCycleUsingPointer(listNode);
    }
}
