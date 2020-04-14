package BFS.P515;

import CommonUtils.TreeNode;
import CommonUtils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
 * You need to find the largest value in each row of a binary tree.
 *
 * Example:
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * Output: [1, 3, 9]
 *
 *
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result= new ArrayList<>();
        if (root==null) return result;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            //记录当前节点的深度
            int currentSize=queue.size();
            Integer tempMax=Integer.MIN_VALUE;
            //当前节点位置开始循环
            for (int i = 0; i < currentSize; i++) {
                TreeNode treeNode=queue.poll();
                tempMax=Math.max(treeNode.val,tempMax);

                if (treeNode.left!=null) queue.offer(treeNode.left);
                if (treeNode.right!=null) queue.offer(treeNode.right);

            }
            result.add(tempMax);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode= TreeNodeUtils.stringToTreeNode("");
        //new Solution().largestValues()
    }
}