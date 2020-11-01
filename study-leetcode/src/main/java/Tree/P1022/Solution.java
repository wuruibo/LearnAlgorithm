package Tree.P1022;

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
    private int result=0;
    public int sumRootToLeaf(TreeNode root) {
        dfs(0,root);
        return result;
    }
    private void dfs(Integer value,TreeNode root){
        if (root.left==null && root.right==null) {
            //将temp转换成数字
            value=((value<<1)+root.val)%1000000007;
            result+=value;
            result%=1000000007;
            return;
        }
        int current=((value<<1)+root.val)%1000000007;
        if (root.left!=null) {
            dfs(current,root.left);
        }
        if (root.right!=null) {
            dfs(current,root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root= TreeNodeUtils.stringToTreeNode("[1,0,1,0,1,0,1]");
        System.out.println(new Solution().sumRootToLeaf(root));
    }
}