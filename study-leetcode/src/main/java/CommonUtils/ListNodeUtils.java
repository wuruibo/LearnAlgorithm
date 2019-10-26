package CommonUtils;

import AddTwoNumbers.ListNode;

/**
 * @autor yeqiaozhu.
 * @date 2019-04-29
 */
public class ListNodeUtils {

    public static ListNode createListNode(int length, int step){
        int i=0;
        ListNode listNode= new ListNode(0);
        ListNode tailListNode= listNode;
        while (i<length){
            tailListNode.next =new ListNode(i);
            tailListNode = tailListNode.next;
            i+=step;
        }
        return listNode.next;
    }

    public static void printListNodes(ListNode listNode){
        while (listNode !=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode buildWithArray(int[] arrays){
        ListNode head=new ListNode(0);
        ListNode current=head;
        for (int i = 0; i < arrays.length; i++) {
            ListNode newHead=new ListNode(arrays[i]);
            current.next=newHead;
            current=newHead;
        }
        return head.next;
    }
}
