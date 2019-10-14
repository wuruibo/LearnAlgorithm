package P226;

import CommonUtils.TreeNodeUtils;
import P104.TreeNode;

/**
 * 递归递归
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        invertTree(root.left);
        invertTree(root.right);
        return null;
    }

    public static void main(String[] args) {
        int[] ints={4,2,1,3,7,6,9};
        TreeNode root=TreeNodeUtils.buildTreeNodeUsingArray(ints);

        new Solution().invertTree(root);
    }

}
