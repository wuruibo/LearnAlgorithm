package 剑指offer.P28;

import CommonUtils.TreeNode;

import java.util.LinkedList;

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
    public boolean isSymmetric(TreeNode root) {
        if (root==null) {
            return true;
        }
        LinkedList<TreeNode> queue= new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size=queue.size();
            for (int i = 0; i < (size>>1); i++) {
                if (queue.get(i)!=queue.get(size-1-i)) {
                    return false;
                }
            }
            for (int j = 0; j < size; j++) {
                TreeNode current=queue.poll();

                if (current.left!=null) {
                    queue.offer(current.left);
                }
                if (current.right!=null) {
                    queue.offer(current.right);
                }
            }
        }
        return true;
    }
}