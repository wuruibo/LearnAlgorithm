
package BinarySearch.P230;

import CommonUtils.TreeNodeUtils;
import WaitingCollect.P104.TreeNode;

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
    private int target;
    private int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k=k;
        //递归找到第k小的数字
        recursive(root);
        return target;
    }
    public void recursive(TreeNode root){
        if (root==null) {
            return;
        }
        recursive(root.left);
        //do something here
        if (--k==0) {target=root.val;}
        recursive(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode= TreeNodeUtils.stringToTreeNode("[5,3,6,2,4,null,null,1]");
        TreeNode treeNode1= TreeNodeUtils.stringToTreeNode(" [3,1,4,null,2]");
        System.out.println(new Solution().kthSmallest(treeNode,3));
        System.out.println(new Solution().kthSmallest(treeNode1,1));
    }

}