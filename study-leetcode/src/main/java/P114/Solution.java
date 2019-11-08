package P114;

import CommonUtils.TreeNodeUtils;
import P104.TreeNode;

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

    public void flatten(TreeNode root) {
        treeToLinkedList(root);
    }
    public TreeNode treeToLinkedList(TreeNode root){
        if (root==null) {
            return null;
        }
        TreeNode left=treeToLinkedList(root.left);
        TreeNode right=treeToLinkedList(root.right);
        root.right=left;
        root.left=null;
        TreeNode temp=root;

        while (temp.right!=null){
            temp=temp.right;
        }
        temp.right=right;
        return root;
    }

    public static void main(String[] args) {
        int[] ints={7,5,6,1,2,3,4};
        TreeNode root=TreeNodeUtils.buildTreeNodeUsingArray(ints);
        new Solution().flatten(root);
    }
}