package BFS.P513;

import CommonUtils.TreeNode;
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
    public int findBottomLeftValue(TreeNode root) {

        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);

        TreeNode first=root;
        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current=queue.poll();
                if (i==0) first=current;
                if (current.left!=null) queue.offer(current.left);
                if (current.right!=null) queue.offer(current.right);
            }
        }

        return first.val;
    }

    public static void main(String[] args) {
        //TreeNode treeNode= TreeNodeUtils.stringToTreeNode();
    }
}