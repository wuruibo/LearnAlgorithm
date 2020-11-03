package Tree.P285;

import CommonUtils.TreeNode;
import CommonUtils.TreeNodeUtils;

import java.util.Stack;

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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null){
            return null;
        }
        Stack<TreeNode> stack = new Stack();
        while(!stack.isEmpty()||root!=null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(p.val<root.val){
                return root;
            }
            root = root.right;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root= TreeNodeUtils.stringToTreeNode("[5,3,6,2,4,null,null,1]");
        new Solution().inorderSuccessor(root,new TreeNode(6));
    }
}