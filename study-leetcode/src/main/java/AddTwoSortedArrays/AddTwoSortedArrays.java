package AddTwoSortedArrays;

import AddTwoNumbers.ListNode;
import CommonUtils.ListNodeUtils;

/**
 * 两个有序链表相加
 * @autor yeqiaozhu.
 * @date 2019-04-28
 */
public class AddTwoSortedArrays {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode indexListNode1=l1;
        ListNode indexListNode2=l2;
        ListNode newListNode=new ListNode(1);
        ListNode tailNewListNode = newListNode;
        while(indexListNode1!=null || indexListNode2 !=null){
            if(indexListNode1 == null){
                tailNewListNode.next = indexListNode2;
                indexListNode2 = indexListNode2.next;
            }else if(indexListNode2 ==null){
                tailNewListNode.next =indexListNode1;
                indexListNode1 =indexListNode1.next;
            }else {
                if(indexListNode1.val <indexListNode2.val){
                    tailNewListNode.next = indexListNode1;
                    indexListNode1 = indexListNode1.next;
                }else {
                    tailNewListNode.next = indexListNode2;
                    indexListNode2 =indexListNode2.next;
                }
            }
            tailNewListNode = tailNewListNode.next;
        }
        return newListNode.next;
    }

    public static void main(String[] args) {
        ListNode l1= ListNodeUtils.createListNode(10,2);
        ListNode l2=ListNodeUtils.createListNode(10,3);
        ListNode newListNode=new AddTwoSortedArrays().mergeTwoLists(l1,l2);
        while (newListNode !=null){
            System.out.println(newListNode.val);
            newListNode = newListNode.next;
        }
    }

}
