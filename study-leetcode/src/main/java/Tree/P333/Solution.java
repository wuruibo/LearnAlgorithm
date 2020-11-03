package Tree.P333;

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
    int max = 0;
    public int largestBSTSubtree(TreeNode root) {
        largest(root);
        return max;
    }

    /**
     * [子树最大值，子树最小值,子树BST的大小（为-1表示不是BST）]
     * @param root
     * @return
     */
    public Integer[] largest(TreeNode root) {
        if (root == null) {
            return new Integer[]{null,null,0};
        }
        Integer[] left = largest(root.left);
        Integer[] right = largest(root.right);
        if (left[2] < 0 || right[2] < 0) {
            return new Integer[]{0,0,-1};
        }
        if (left[0] != null && root.val <= left[0]
                || right[1] != null && root.val >= right[1]) {
            return new Integer[] {0,0,-1};
        }
        int localMax = right[0] == null? root.val:right[0];
        int localMin = left[1] == null? root.val: left[1];
        max = Math.max(max,left[2] + right[2] + 1);
        return new Integer[]{localMax,localMin,left[2] + right[2] + 1};
    }

    public static void main(String[] args) {
        TreeNode root= TreeNodeUtils.stringToTreeNode("[4,2,7,2,3,5,null,2,null,null,null,null,null,1]");
        System.out.println(new Solution().largestBSTSubtree(root));
    }
}