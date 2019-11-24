package BST;

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
    private int minValue=Integer.MAX_VALUE;
    private TreeNode pre;
    public int minDiffInBST(TreeNode root) {
        minDiffRecur(root);
        return this.minValue;
    }

    public void minDiffRecur(TreeNode root){
        if (root==null) {
            return;
        }
        minDiffRecur(root.left);
        //在这里遍历就是先序遍历
        if (pre==null) {
            pre=root;
        }else {
            minValue=Math.min(minValue,Math.abs(root.val-pre.val));
            pre=root;
        }
        minDiffRecur(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode=TreeNodeUtils.stringToTreeNode("[4,2,6,1,3,null,null]");
        TreeNode treeNode1=TreeNodeUtils.stringToTreeNode("[4,2]");
        TreeNode treeNode2=TreeNodeUtils.stringToTreeNode("[90,69,null,49,89,null,52,null,null,null,null]");
        System.out.println(new Solution().minDiffInBST(treeNode));
        System.out.println(new Solution().minDiffInBST(treeNode1));
        System.out.println(new Solution().minDiffInBST(treeNode2));
    }
}