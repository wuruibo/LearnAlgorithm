package WaitingCollect.P236;
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root.val==p.val || root.val==q.val){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if (left!=null && right!=null) {
            return root;
        }
        return left!=null?left:right;
    }

    public static void main(String[] args) {
        int[] ints={3,5,1,6,2,0,8,7,4};
        TreeNode treeNode=TreeNodeUtils.buildTreeNodeUsingArray(ints);
        new Solution().lowestCommonAncestor(treeNode,treeNode.left.left,treeNode.right);
    }
}