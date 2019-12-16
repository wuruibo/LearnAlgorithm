package DepthFirstSearch.P101;

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
 * 递归哟
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricSon(root.left,root.right);
    }
    public boolean isSymmetricSon(TreeNode left,TreeNode right){
        if (left==null && right==null) {
             return true;
        }else if(left!=null && right!=null){
            return left.val==right.val && isSymmetricSon(left.left,right.right) && isSymmetricSon(left.right,right.left);
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode=TreeNodeUtils.stringToTreeNode("[1,2,2,3,4,4,3]");
        System.out.println(new Solution().isSymmetric(treeNode));

        TreeNode treeNode1=TreeNodeUtils.stringToTreeNode("[1,2,2,null,3,null,3]");
        System.out.println(new Solution().isSymmetric(treeNode1));

        TreeNode treeNode2=TreeNodeUtils.stringToTreeNode("[1,2,2,2,null,2]");
        System.out.println(new Solution().isSymmetric(treeNode2));
    }
}