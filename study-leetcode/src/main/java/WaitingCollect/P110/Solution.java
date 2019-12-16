package WaitingCollect.P110;

import CommonUtils.TreeNode;

/**
 * 判断左右递归子树的差距是不是大于1
 * 注意不能用最大深度减去最小深度
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return height(root)==-1?false:true;
    }
    public int height(TreeNode treeNode){
        if (treeNode == null) {
            return 0;
        }
        int leftHeight=height(treeNode.left);
        int rightHeight=height(treeNode.right);
        if(leftHeight==-1 || rightHeight==-1 || Math.abs(leftHeight-rightHeight)>1)
            return -1;
        return Math.max(leftHeight,rightHeight)+1;
    }

}