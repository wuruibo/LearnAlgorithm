package Tree.P450;

import CommonUtils.TreeNode;
import CommonUtils.TreeNodeUtils;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null) {
            return null;
        }
        if (root.val>key) {
            TreeNode left=deleteNode(root.left,key);
            root.left=left;
        }else if (root.val<key){
            TreeNode right=deleteNode(root.right,key);
            root.right=right;
        }else {
            //如果相等 尝试拼接左右两边的二叉树
            return dfs(root.left, root.right);
        }
        return root;
    }
    private TreeNode dfs(TreeNode left,TreeNode right){
        if (right==null) {
            return left;
        }
        if (left==null) {
            return right;
        }
        if (left.val>right.val) {
            TreeNode r=dfs(left,right.right);
            right.right=r;
        }else if (left.val<right.val){
            TreeNode l=dfs(left,right.left);
            right.left=l;
        }
        return right;
    }

    public static void main(String[] args) {
        TreeNode root= TreeNodeUtils.stringToTreeNode("[1,null,2]");
        new Solution().deleteNode(root,1);
    }
}