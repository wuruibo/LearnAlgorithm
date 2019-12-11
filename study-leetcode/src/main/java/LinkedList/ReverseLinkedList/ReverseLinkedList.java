package LinkedList.ReverseLinkedList;

import LinkedList.AddTwoNumbers.ListNode;
import CommonUtils.ListNodeUtils;

import java.util.ArrayList;

/**
 * 链表反转
 *
 * @autor yeqiaozhu.
 * @date 2019-05-06
 */
public class ReverseLinkedList {
    private ArrayList<ListNode> reverseListNode=new ArrayList<>();


    public ListNode newHead;
    /**
     * method 3：递归+数组
     * 对递归的理解不够深刻，实际上是递归的复杂版本
     * @param head
     * @return
     */
    public ListNode reverseListUsingList(ListNode head) {
        if(head == null){
            return null;
        }
        //get(head);
        getReverseListNode(head);
        ListNode reverse=new ListNode(0);
        ListNode indexList = reverse;
        for(int i=0;i<reverseListNode.size();i++){
            indexList.next=new ListNode(reverseListNode.get(i).val);
            indexList = indexList.next;
        }
        return reverse.next;
    }

    public ListNode reverseListOneScanMoreClear(ListNode head){

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    /**
     * method 2:一次遍历整个链表
     * @param head
     * @return
     */
    public ListNode reverseListOneScan(ListNode head){
        if(head ==null || head.next ==null){
            return head;
        }
        ListNode tailHead = head;
        ListNode firstHead =head;
        ListNode currentHead;
        head = head.next;
        while (head!=null){
            currentHead = head;
            head = head.next;
            currentHead.next = tailHead;
            tailHead = currentHead;
        }
        firstHead.next =null;
        return tailHead;
    }
    /**
     * method 1 : 利用递归进行反转
     * 递归返回的节点每次都是尾节点可以直接追加
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){
        reverseToTail(head);
        return this.newHead;
    }
    public ListNode reverseToTail(ListNode node){
        if(node == null || node.next==null){
            this.newHead=node;
            return node;
        }else {
            ListNode tempListNode=reverseToTail(node.next);
            tempListNode.next=node;
            node.next =null;
            return node;
        }
    }
    public ListNode reverseListTest(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
    private void getReverseListNode(ListNode head){
        if(head.next ==null){
            reverseListNode.add(head);
        }else {
            getReverseListNode(head.next);
            reverseListNode.add(head);
        }
    }

    private void get(ListNode head){
        if(head.next!=null){
            get(head.next);
        }
        reverseListNode.add(head);
    }
    public static void main(String[] args) {
        //递归
        ListNodeUtils.printListNodes(new ReverseLinkedList().reverseListTest(ListNodeUtils.createListNode(2,1)));
        //非递归
        ListNodeUtils.printListNodes(new ReverseLinkedList().reverseListOneScanMoreClear(ListNodeUtils.createListNode(5,1)));

    }
}
