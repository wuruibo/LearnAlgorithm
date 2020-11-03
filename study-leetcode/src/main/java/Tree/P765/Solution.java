package Tree.P765;

import CommonUtils.TreeNode;

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
    public boolean isUnivalTree(TreeNode root) {
        if (root==null) {
            return true;
        }
        int left=root.left==null?root.val:root.left.val;
        int right=root.right==null?root.val:root.right.val;

        return root.val==left && root.val==right && isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}