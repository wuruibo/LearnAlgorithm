package 剑指offer.P55;

import CommonUtils.TreeNode;
import CommonUtils.TreeNodeUtils;

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
    private boolean balanced=true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return balanced;
    }
    private int dfs(TreeNode root){
        if (root==null) {
            return 0;
        }
        int left=dfs(root.left);
        int right=dfs(root.right);
        if (Math.abs(left-right)>1) {
            balanced=false;
        }
        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {
        TreeNode root= TreeNodeUtils.stringToTreeNode("[1,2,2,3,3,null,null,4,4]");
        System.out.println(new Solution().isBalanced(root));
    }
}