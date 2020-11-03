package Tree.P669;

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

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        //如果当前节点大于最大值 去裁剪左子树 直接抛弃右子树 返回裁剪左子树的根节点
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        //如果当前节点小于最小值 去裁剪右子树 直接抛弃左子树 返回裁剪右子树的根节点
        if (root.val < L) {
            return trimBST(root.right, L, R);
        }
        //如果当前节点在最大和最小值中间 左子树和右子树都需要裁剪 返回的根节点组装
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }


    public static void main(String[] args) {
        TreeNode root= TreeNodeUtils.stringToTreeNode("[3,0,4,null,2,null,null,1]");
        new Solution().trimBST(root,1,3);

        TreeNode root1= TreeNodeUtils.stringToTreeNode("[1,null,2]");
        new Solution().trimBST(root1,2,4);
    }
}