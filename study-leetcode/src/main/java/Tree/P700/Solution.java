package Tree.P700;

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
    /**
     * 递归
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    /**
     * 迭代
     */
    public TreeNode searchBSTDie(TreeNode root, int val) {
        while (true) {
            if (root == null || root.val == val) {
                return root;
            }
            root = root.val > val ? root.left : root.right;
        }
    }
}