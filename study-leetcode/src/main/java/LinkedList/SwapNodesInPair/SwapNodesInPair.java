package LinkedList.SwapNodesInPair;

import AddTwoNumbers.ListNode;
import CommonUtils.ListNodeUtils;

/**
 * 相邻节点倒转
 * 链表
 * @autor yeqiaozhu.
 * @date 2019-05-07
 */
public class SwapNodesInPair {
    /**
     * 一开始写的，不是特别清晰，逻辑有点混乱
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next ==null){
            return head;
        }
        ListNode currentListNode;
        ListNode nextListNode;
        ListNode newHead = head.next;
        while (head != null && head.next !=null){

            currentListNode = head.next;
            nextListNode = head.next.next;

            if(nextListNode ==null){
                head.next =null;
            } else if(nextListNode!=null && nextListNode.next ==null){
                head.next = nextListNode;
            } else {
                head.next = nextListNode.next;
            }
            currentListNode.next = head;

            head = nextListNode;
        }

        return newHead;
    }

    /**
     * Method 1：一遍遍历更清晰的版本
     * @param head
     * @return
     */
    public ListNode swapPairsMoreClear(ListNode head){
        ListNode current = new ListNode(0);
        current.next = head;
        ListNode newHead = current;
        while (current.next !=null && current.next.next!=null){
            ListNode first = current.next;
            ListNode second = current.next.next;

            current.next = second;
            first.next= second.next;
            second.next=first;

            current = first;
        }

        return newHead.next;
    }
    public static void main(String[] args) {
        //ListNodeUtils.printListNodes(new SwapNodesInPair().swapPairs(ListNodeUtils.createListNode(7,1)));


        ListNodeUtils.printListNodes(new SwapNodesInPair().swapPairsMoreClear(ListNodeUtils.createListNode(1,1)));

    }
}
