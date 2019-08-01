import AddTwoNumbers.ListNode;
import CommonUtils.ListNodeUtils;

/**
 * @autor yeqiaozhu.
 * @date 2019-06-14
 */
public class Test {

    public static void digui(ListNode listNode){
        if(listNode.next==null){
            System.out.println(listNode.val);
            return;
        }
        digui(listNode.next);
        System.out.println(listNode.val);
    }
    public static void main(String[] args) {
        ListNode head=ListNodeUtils.createListNode(10,2);
        ListNodeUtils.printListNodes(head);

        digui(head);
    }
}
