package DepthFirstSearch.P129;

import CommonUtils.TreeNodeUtils;
import WaitingCollect.P104.TreeNode;

/**
 * 计算可能的所有的结果和
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int sum=0;
    public int sumNumbers(TreeNode root) {
        if (root==null) {
            return 0;
        }
        dfs(root,0);
        return sum;
    }
    public void dfs(TreeNode root,int temp){

        int next=temp*10+root.val;
        if (root.left==null && root.right==null) {
            //到达叶子节点
            sum+=next;
        }
        if (root.left!=null) {
            dfs(root.left,next);
        }
        if (root.right!=null) {
            dfs(root.right,next);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode= TreeNodeUtils.stringToTreeNode("[1,2,3]");
        System.out.println(new Solution().sumNumbers(treeNode));

        TreeNode treeNode1= TreeNodeUtils.stringToTreeNode("[4,9,0,5,1]");
        System.out.println(new Solution().sumNumbers(treeNode1));
    }
}