package Tree.P998;

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
    /**
     * 模拟在最大堆中插入一个元素val
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root==null || val>root.val) {
            TreeNode current=new TreeNode(val);
            current.left=root;
            return current;
        }
        TreeNode right=insertIntoMaxTree(root.right,val);
        root.right=right;
        return root;
    }
    public static void main(String[] args) {
        TreeNode root= TreeNodeUtils.stringToTreeNode("[4,1,3,null,null,2]");
        new Solution().insertIntoMaxTree(root,5);

        TreeNode root2= TreeNodeUtils.stringToTreeNode("[5,2,4,null,1]");
        new Solution().insertIntoMaxTree(root2,3);

        TreeNode root1= TreeNodeUtils.stringToTreeNode("[5,2,3,null,1]");
        new Solution().insertIntoMaxTree(root1,4);
    }
}