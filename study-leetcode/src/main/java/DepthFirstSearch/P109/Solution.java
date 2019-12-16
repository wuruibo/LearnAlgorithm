package DepthFirstSearch.P109; /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import LinkedList.AddTwoNumbers.ListNode;
import CommonUtils.ListNodeUtils;
import CommonUtils.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode temp;
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBSTRecur(head);
    }
    public TreeNode sortedListToBSTRecur(ListNode start){
        if (start==null) {
            return null;
        }
        if (start.next==null) {
            return new TreeNode(start.val);
        }
        ListNode fastP=start;
        ListNode slowPre=start;
        ListNode slowP=start;
        for (;fastP!=null && fastP.next!=null;){
            slowPre=slowP;
            slowP=slowP.next;
            fastP=fastP.next.next;
        }
        //将前节点置空
        slowPre.next=null;
        ListNode slowNext=slowP.next;
        //后节点置空
        slowP.next=null;
        TreeNode treeNodeLeft=sortedListToBSTRecur(start);
        TreeNode treeNodeRight=sortedListToBSTRecur(slowNext);

        //reverse treeNodeLeft
        TreeNode mid=new TreeNode(slowP.val);
        mid.left=treeNodeLeft;
        mid.right=treeNodeRight;

        return mid;
    }

    public static void main(String[] args) {
        int[] ints={-10,-3,0,5,9};
        ListNode listNode= ListNodeUtils.buildWithArray(ints);

        new Solution().sortedListToBST(listNode);

        new Solution().reverseListNodeTreeNode(listNode);
    }

    public TreeNode reverseListNodeTreeNode(ListNode start){
        if (start.next==null) {
            temp=new TreeNode(start.val);
            return temp;
        }
        TreeNode tail=reverseListNodeTreeNode(start.next);
        TreeNode newTail=new TreeNode(start.val);

        tail.left=newTail;
        return newTail;
    }

}