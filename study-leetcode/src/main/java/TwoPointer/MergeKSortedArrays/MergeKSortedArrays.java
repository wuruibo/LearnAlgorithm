package TwoPointer.MergeKSortedArrays;


import LinkedList.AddTwoNumbers.ListNode;
import CommonUtils.ListNodeUtils;

/**
 * @autor yeqiaozhu.
 * @date 2019-05-06
 */
public class MergeKSortedArrays {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode[] tempListNode = new ListNode[lists.length];
        for (int i = 0; i < lists.length; i++) {
            if (i == 0) {
                tempListNode[i] = lists[i];
            } else {
                //tempListNode[i] = new AddTwoSortedArrays().mergeTwoLists(tempListNode[i - 1], lists[i]);
            }
        }
        return tempListNode[lists.length - 1];
    }

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[5];
        for (int i = 0; i < 5; i++) {
            listNodes[i] = ListNodeUtils.createListNode(10, i + 1);
        }
        ListNodeUtils.printListNodes(new MergeKSortedArrays().mergeKLists(listNodes));
    }
}
