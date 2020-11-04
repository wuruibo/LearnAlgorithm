package Tree.P1026;

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
 */
class Solution {
    private int max=0;
    public int maxAncestorDiff(TreeNode root) {
        if (root==null) {
            return max;
        }
        dfs(root);
        return max;
    }
    private int[] dfs(TreeNode root){
        if (root.left==null && root.right==null) {
            return new int[]{root.val,root.val};
        }
        int[] left=new int[]{root.val,root.val};
        int[] right=new int[]{root.val,root.val};
        if (root.left!=null) {
            left=dfs(root.left);
        }
        if (root.right!=null) {
            right=dfs(root.right);
        }
        int min=Math.min(root.val,Math.min(left[0],right[0]));
        int max=Math.max(root.val,Math.max(left[1],right[1]));
        int[] current=new int[]{min,max};
        //计算左边的最大差
        int leftMax=Math.max(Math.abs(root.val-left[0]),Math.abs(root.val-left[1]));
        int rightMax=Math.max(Math.abs(root.val-right[0]),Math.abs(root.val-right[1]));
        this.max=Math.max(this.max,Math.max(leftMax,rightMax));
        return current;
    }

    public static void main(String[] args) {
        TreeNode root= TreeNodeUtils.stringToTreeNode("[8,3,10,1,6,null,14,null,null,4,7,13]");
        System.out.println(new Solution().maxAncestorDiff(root));

        TreeNode root1= TreeNodeUtils.stringToTreeNode("[1,2,4,-2]");
        System.out.println(new Solution().maxAncestorDiff(root1));
    }
}