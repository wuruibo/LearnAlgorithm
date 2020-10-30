package Tree.P549;

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
 * 将子问题inc理解为以当前根节点为起点向左或者向右的最大递增
 * 将子问题dec理解为以当前根节点为起点向左或者向右的最大递减
 */
class Solution {
    private int max=0;
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return max;
    }
    private int[] dfs(TreeNode root){
        if (root==null) {
            return new int[]{0,0};
        }
        int inc=1,dec=1;
        if (root.left!=null) {
            int[] left=dfs(root.left);
            if (root.val-root.left.val==1) {
                dec=left[1]+1;
            }else if(root.left.val-root.val==1) {
                inc=left[0]+1;
            }
        }
        if (root.right!=null) {
            int[] right=dfs(root.right);
            if (root.val-root.right.val==1) {
                dec=Math.max(dec,right[1]+1);
            }else if (root.right.val-root.val==1){
                inc=Math.max(inc,right[0]+1);
            }
        }
        int[] current=new int[]{inc,dec};
        max=Math.max(max,inc+dec-1);
        return current;
    }

    public static void main(String[] args) {
        TreeNode root= TreeNodeUtils.stringToTreeNode("[1]");
        System.out.println(new Solution().longestConsecutive(root));
        TreeNode treeNode= TreeNodeUtils.stringToTreeNode("[1,2,3]");
        System.out.println(new Solution().longestConsecutive(treeNode));
    }
}