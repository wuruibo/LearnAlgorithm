package WaitingCollect.P160;

import AddTwoNumbers.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 通过set的方式实现，需要占用额外的空间
 * 时间复杂度O(M+N)
 * 空间复杂度O(M)/O(N)
 * @autor yeqiaozhu.
 * @date 2019-10-10
 */
public class UsingSet {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB==null) {
            return null;
        }
        ListNode a=headA;
        ListNode b=headB;
        Set<ListNode> aSet=new HashSet<>();
        while (a!=null){
            aSet.add(a);
            a=a.next;
        }
        //遍历一下
        while (b!=null){
            if (aSet.contains(b)) {
                return b;
            }
            b=b.next;
        }
        return null;

    }
}
