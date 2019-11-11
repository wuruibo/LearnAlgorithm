package P94;

import CommonUtils.TreeNodeUtils;
import P104.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
    private List<Integer> result= new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        recursive(root);
        return result;
    }
    public void recursive(TreeNode root){
        if (root==null) {
            return;
        }
        recursive(root.left);
        result.add(root.val);
        recursive(root.right);
    }

    public static void main(String[] args) {
        String string="[10,5,15,null,null,6,20]";
        TreeNode root= TreeNodeUtils.stringToTreeNode(string);
        new Solution().inorderTraversal(root);
    }
}