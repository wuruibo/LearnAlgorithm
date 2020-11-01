package Tree.合法二叉搜索树;

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
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> deque= new LinkedList<>();
        List<Integer> result= new ArrayList<>();
        TreeNode current = root;
        while (current!= null || !deque.isEmpty()) {
            while (current != null) {
                deque.offerLast(current);
                current=current.left;
            }
            TreeNode treeNode=deque.pollLast();
            result.add(treeNode.val);
            current=treeNode.right;
        }
        //result差
        for (int i = 1; i < result.size(); i++) {
            if (result.get(i)<result.get(i-1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root= TreeNodeUtils.stringToTreeNode("[-2147483648,null,2147483647]");
        System.out.println(new Solution().isValidBST(root));
    }

}