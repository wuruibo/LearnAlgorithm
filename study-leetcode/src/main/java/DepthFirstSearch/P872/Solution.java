package DepthFirstSearch.P872;

import CommonUtils.ArrayUtils;
import CommonUtils.TreeNode;
import CommonUtils.TreeNodeUtils;

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
 *
 *
 *
 * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
 *
 *
 *
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 *
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 *
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 *
 *
 *
 * Constraints:
 *
 * Both of the given trees will have between 1 and 200 nodes.
 * Both of the given trees will have values between 0 and 200
 */
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> first= new ArrayList<>();
        List<Integer> second=new ArrayList<>();

        inorder(root1,first);
        inorder(root2,second);

        return first.equals(second);
    }

    private void inorder(TreeNode root, List<Integer> leafs){
        if (root==null) return;
        if (root.left==null && root.right==null) {
            leafs.add(root.val);
        }
        inorder(root.left,leafs);
        inorder(root.right,leafs);
    }

    public static void main(String[] args) {
        TreeNode left= TreeNodeUtils.stringToTreeNode("[3,5,6,null,null,2,7,null,null,4,null,null,1,9,null,null,8,null,null]");
        TreeNode right= TreeNodeUtils.stringToTreeNode("");
        System.out.println(new Solution().leafSimilar(left,right));
    }
}