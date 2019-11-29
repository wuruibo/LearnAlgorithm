package WaitingCollect.P111;

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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int minDepth,minDepthLeft,minDepthRight;
        minDepthLeft=minDepth(root.left);
        minDepthRight=minDepth(root.right);

        if(minDepthLeft==0){
            minDepth=minDepthRight;
        }else if(minDepthRight==0){
            minDepth=minDepthLeft;
        }else {
            minDepth=Math.min(minDepthLeft,minDepthRight);
        }
        return minDepth+1;
    }
    public static void main(String[] args) {
        int[] ints={1,2};
        TreeNode treeNode= TreeNodeUtils.buildTreeNodeUsingArray(ints);
        System.out.println(new WaitingCollect.P111.Solution().minDepth(treeNode));
    }
}