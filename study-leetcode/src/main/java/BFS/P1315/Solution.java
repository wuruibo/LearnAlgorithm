package BFS.P1315;

import CommonUtils.TreeNode;
import CommonUtils.TreeNodeUtils;

import java.util.LinkedList;
import java.util.Queue;

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
    public int sumEvenGrandparent(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        //LevelOrderTraversal
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node.left != null) {
                q.add(node.left);
                if(node.val % 2 == 0) {
                    if(node.left.left != null) {
                        sum += node.left.left.val;
                    }
                    if(node.left.right != null) {
                        sum += node.left.right.val;
                    }
                }
            }

            if(node.right != null) {
                q.add(node.right);
                if(node.val % 2 == 0) {
                    if(node.right.left != null) {
                        sum += node.right.left.val;
                    }
                    if(node.right.right != null) {
                        sum += node.right.right.val;
                    }
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        TreeNode treeNode= TreeNodeUtils.stringToTreeNode("[6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]");
        System.out.println(new Solution().sumEvenGrandparent(treeNode));
    }
}