package LinkedList.RemoveNodeFromEnd;

import LinkedList.AddTwoNumbers.ListNode;
import CommonUtils.ListNodeUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * @autor yeqiaozhu.
 * @date 2019-04-29
 */
public class RemoveNodeFromEnd {
    /**
     * 通过hash存储的方式既占用了空间，而且链表中的值是会有重复的，这个导致错误。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tempListNodeHead = head;
        int index = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        while (tempListNodeHead != null) {
            hashMap.put(tempListNodeHead.val, index++);
            tempListNodeHead = tempListNodeHead.next;
        }
        //将要删除的节点位置index
        int indexToDelete = index - n;
        tempListNodeHead = head;
        while (tempListNodeHead != null) {
            //匹配到前一个节点
            if (hashMap.get(tempListNodeHead.val).intValue() == indexToDelete - 1 && indexToDelete > 0) {
                tempListNodeHead.next = tempListNodeHead.next.next;
                break;
            } else if (indexToDelete == 0) {
                head = head.next;
                break;
            } else {
                tempListNodeHead = tempListNodeHead.next;
            }
        }
        return head;
    }

    /**
     * 先遍历一遍链表获得长度，在遍历一遍链表进行删除节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndTwo(ListNode head, int n) {
        ListNode tempListNode = head;
        int length = 0;
        //遍历一边计算长度
        while(tempListNode !=null){
            length++;
            tempListNode = tempListNode.next;
        }
        //再遍历一遍，n+index如果 == length定位到需要被删除的元素，但是如果n == length，第一个元素是没有前面一个元素的，需要特殊处理
        int indexNode=0;
        tempListNode = head;
        while (tempListNode != null){
            if(indexNode+n+1 == length && n != length ){
                tempListNode.next = tempListNode.next.next;
                break;
            }else if(n == length ){
                head = head.next;
                break;
            }else {
                tempListNode = tempListNode.next;
            }
            indexNode++;
        }
        return head;
    }

    /**
     * 可以只做一次循环，两个指针遍历,维持固定的距离
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndThree(ListNode head, int n) {
        ListNode listNode=new ListNode(0);
        listNode.next=head;
        ListNode first=listNode;
        ListNode second =listNode;
        for(int i=0;i<=n;i++){
            first = first.next;
        }
        while (first !=null){
            second =second.next;
            first= first.next;
        }
        second.next=second.next.next;
        //注意这里不能返回head 吃了点亏
        return listNode.next;
    }
        public static void main(String[] args) {
       /* ListNode listNode = ListNodeUtils.createListNode(1, 2);
        ListNodeUtils.printListNodes(new LinkedList.RemoveNodeFromEnd().removeNthFromEnd(listNode, 1));*/

        /*ListNode listNode = ListNodeUtils.createListNode(3, 2);
        ListNodeUtils.printListNodes(new LinkedList.RemoveNodeFromEnd().removeNthFromEndTwo(listNode, 2));*/

        ListNode listNode = ListNodeUtils.createListNode(1, 2);
        ListNodeUtils.printListNodes(new RemoveNodeFromEnd().removeNthFromEndThree(listNode, 1));
    }
}
