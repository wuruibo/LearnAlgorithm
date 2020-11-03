package Tree.P701;

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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root==null) {
            return new TreeNode(val);
        }
        if (root.val>val) {
            TreeNode left=insertIntoBST(root.left,val);
            root.left=left;
        }else if (root.val<val){
            TreeNode right=insertIntoBST(root.right,val);
            root.right=right;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root= TreeNodeUtils.stringToTreeNode("[40,20,60,10,30,50,70]");
        new Solution().insertIntoBST(root,25);
    }
}