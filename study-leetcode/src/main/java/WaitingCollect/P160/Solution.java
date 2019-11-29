package WaitingCollect.P160;

import AddTwoNumbers.ListNode;
import CommonUtils.ListNodeUtils;

/**
 * 时间复杂度O(M+N)
 * 空间复杂度O(1)
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB==null) {
            return null;
        }
        ListNode a=headA;
        ListNode b=headB;
        //如果同时到达尾部 没有交点直接返回null
        while (a!=b){
            //a一遍循环结束没有找到交点 继续从b开头节点开始往下走
            a=a==null?headA:a.next;
            //b一遍循环结束没有找到交点 继续从a开头节点开始循环 最后一定会遇到交点的
            b=b==null?headB:b.next;
        }
        return a;
    }

    public static void main(String[] args) {
        ListNode listNodeA=ListNodeUtils.createListNode(4,1);
        ListNode listNodeB=ListNodeUtils.createListNode(4,2);

        new Solution().getIntersectionNode(listNodeA,listNodeB);
    }
}