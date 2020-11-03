package Tree.P1469;

import CommonUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> result= new ArrayList<>();
        dfs(root,result);
        return result;
    }
    private void dfs(TreeNode root,List<Integer> temp){
        if (root.left==null && root.right==null) {
            return;
        }
        //收集满足条件的节点
        if (root.left==null) {
            temp.add(root.right.val);
        }else if (root.right==null){
            temp.add(root.left.val);
        }
        if (root.left!=null) {
            dfs(root.left,temp);
        }
        if (root.right!=null) {
            dfs(root.right,temp);
        }
    }
}