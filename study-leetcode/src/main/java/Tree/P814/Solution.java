package Tree.P814;

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
    public TreeNode pruneTree(TreeNode root) {
        boolean preune=dfs(root);
        return preune?root:null;
    }
    private boolean dfs(TreeNode root){
        if (root==null) {
            return false;
        }
        boolean left=dfs(root.left);
        boolean right=dfs(root.right);
        if (!left) {
            root.left=null;
        }
        if (!right) {
            root.right=null;
        }
        return root.val==1 || left || right;
    }

    public static void main(String[] args) {
        TreeNode root= TreeNodeUtils.stringToTreeNode("[1,null,0,0,1]");
        System.out.println(new Solution().pruneTree(root));

        TreeNode root1= TreeNodeUtils.stringToTreeNode("[1,0,1,0,0,0,1]");
        System.out.println(new Solution().pruneTree(root1));

        TreeNode root2= TreeNodeUtils.stringToTreeNode("[1,1,0,1,1,0,1,0]");
        System.out.println(new Solution().pruneTree(root2));
    }
}