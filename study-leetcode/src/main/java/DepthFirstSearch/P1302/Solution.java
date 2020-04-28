package DepthFirstSearch.P1302;

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
 *
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * Output: 15
 */
class Solution {
    private int maxDeep=1;
    private int result=0;
    public int deepestLeavesSum(TreeNode root) {
        dfs(root,1);
        return result;
    }
    private void dfs(TreeNode root,int deep){
        if (root.left==null && root.right==null) {
            if (deep==maxDeep) {
                result+=root.val;
            }else if(deep>maxDeep){
                maxDeep=deep;
                result=root.val;
            }
            return;
        }
        deep++;
        if (root.left!=null) dfs(root.left,deep);
        if (root.right!=null) dfs(root.right,deep);
    }

    public static void main(String[] args) {
        TreeNode treeNode= TreeNodeUtils.stringToTreeNode("[1,2,3,4,5,null,6,7,null,null,null,null,8]");
        System.out.println(new Solution().deepestLeavesSum(treeNode));
    }
}