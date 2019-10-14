
package P617;

import CommonUtils.TreeNodeUtils;
import P104.TreeNode;

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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode newNode=new TreeNode(t1.val+t2.val);

        TreeNode leftNode=mergeTrees(t1.left,t2.left);
        TreeNode rightNode=mergeTrees(t1.right,t2.right);
        newNode.left=leftNode;
        newNode.right=rightNode;
        return newNode;
    }

    public static void main(String[] args) {

        int[] ints1={1,3,2,5};
        int[] ints2={2,1,3,4,7};
       TreeNode treeNode= TreeNodeUtils.buildTreeNodeUsingArray(ints1);
       TreeNode treeNode2= TreeNodeUtils.buildTreeNodeUsingArray(ints2);
       new Solution().mergeTrees(treeNode,treeNode2);

    }
}