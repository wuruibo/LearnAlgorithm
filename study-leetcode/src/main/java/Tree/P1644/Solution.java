package Tree.P1644;

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
    private TreeNode parent=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return parent;
    }
    private TreeNode dfs(TreeNode root,TreeNode p,TreeNode q){
        if(root==null || root.val==p.val || root.val==q.val){
            return root;
        }
        TreeNode left=dfs(root.left,p,q);
        TreeNode right=dfs(root.right,p,q);

        //判断三个节点当中是否存在两个是有实际节点
        boolean rootBool=(root.val==q.val || root.val==p.val);
        boolean result=(rootBool && left!=null) || (rootBool && right!=null) || (left!=null && right!=null);
        if (result && parent==null) {
            parent=root;
        }
        //三个节点中任意一个不为空即可向上返回
        if (rootBool) {
            return root;
        }else if (left!=null) {
            return left;
        }else if (right!=null){
            return right;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode treeNode= TreeNodeUtils.stringToTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
        System.out.println(new Solution().lowestCommonAncestor(treeNode, new TreeNode(5), new TreeNode(4)));
    }
}