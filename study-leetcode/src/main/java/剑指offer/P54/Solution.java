package 剑指offer.P54;

import CommonUtils.TreeNode;
import CommonUtils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
    public int kthLargest(TreeNode root, int k) {
        Deque<TreeNode> deque= new LinkedList<>();
        List<Integer> result= new ArrayList<>();
        TreeNode current=root;
        while (current!=null || !deque.isEmpty()) {
            //先遍历右边
            while (current!= null) {
                deque.offerLast(current);
                current=current.right;
            }
            //弹出栈
            current=deque.pollLast();
            k--;
            if (k==0) {
                return current.val;
            }
            result.add(current.val);
            current=current.left;
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode root= TreeNodeUtils.stringToTreeNode("[5,3,6,2,4,null,null,1]");
        System.out.println(new Solution().kthLargest(root, 3));

        TreeNode root1= TreeNodeUtils.stringToTreeNode("[3,1,4,null,2]");
        System.out.println(new Solution().kthLargest(root1, 1));
    }
}