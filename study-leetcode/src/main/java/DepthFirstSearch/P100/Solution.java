package DepthFirstSearch.P100;

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null) {
            return true;
        }else {
            if (p==null || q==null) {
                return false;
            }
            boolean current=p.val==q.val?true:false;

            boolean left=isSameTree(p.left,q.left);
            boolean right=isSameTree(p.right,q.right);

            return left && right && current;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode= TreeNodeUtils.stringToTreeNode("[1,2]");
        TreeNode treeNode1= TreeNodeUtils.stringToTreeNode("[1,null,2]");
        System.out.println(new Solution().isSameTree(treeNode,treeNode1));


        TreeNode t= TreeNodeUtils.stringToTreeNode("[1,2,3]");
        TreeNode t1= TreeNodeUtils.stringToTreeNode("[1,2,3]");
        System.out.println(new Solution().isSameTree(t,t1));



        TreeNode tree1= TreeNodeUtils.stringToTreeNode("[1,2,1]");
        TreeNode tree= TreeNodeUtils.stringToTreeNode("[1,1,2]");
        System.out.println(new Solution().isSameTree(tree,tree1));
    }
}