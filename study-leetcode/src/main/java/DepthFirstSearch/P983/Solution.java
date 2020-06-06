package DepthFirstSearch.P983;

import CommonUtils.TreeNodeUtils;
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
    private int result=0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        rangeSumBSTRecur(root,L,R);
        return result;
    }
    public void rangeSumBSTRecur(TreeNode root, int L, int R){
        if (root==null) {
            return;
        }
        rangeSumBSTRecur(root.left,L,R);
        if (root.val>=L && root.val<=R) {
            result+=root.val;
        }
        rangeSumBSTRecur(root.right,L,R);
    }

    public static void main(String[] args) {
        TreeNode treeNode=TreeNodeUtils.stringToTreeNode("[10,5,15,3,7,null,18]");

        TreeNode treeNode1=TreeNodeUtils.stringToTreeNode("[10,5,15,3,7,13,18,1,null,6]");


        new Solution().rangeSumBST(treeNode,7,15);
        new Solution().rangeSumBST(treeNode1,6,10);
    }
}