package WaitingCollect.P543;

import WaitingCollect.P104.TreeNode;

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
    private int max=0;
    public int diameterOfBinaryTree(TreeNode root){
        diameterOfBinaryTreeDigui(root);
        return max;
    }
    public int diameterOfBinaryTreeDigui(TreeNode root) {
        if (root==null) {
            return -1;
        }
        int left=diameterOfBinaryTreeDigui(root.left);
        int right=diameterOfBinaryTreeDigui(root.right);

        int result=left+right+2;
        if (result>max) {
            max=result;
        }
        return left>right?left+1:right+1;
    }

    public static void main(String[] args) {

    }
}