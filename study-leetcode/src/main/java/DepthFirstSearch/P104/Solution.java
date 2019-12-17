package DepthFirstSearch.P104;

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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepth=Math.max(maxDepth(root.left),maxDepth(root.right));
        return maxDepth+1;
    }

    public static void main(String[] args) {
        int[] ints={3,9,20,15,7};
        TreeNode treeNode=TreeNodeUtils.buildTreeNodeUsingArray(ints);
        System.out.println(new Solution().maxDepth(treeNode));
    }
}