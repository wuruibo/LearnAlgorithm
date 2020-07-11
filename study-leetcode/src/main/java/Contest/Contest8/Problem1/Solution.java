package Contest.Contest8.Problem1;

import CommonUtils.TreeNode;

import java.util.*;

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> result=new LinkedList<>();
        while (!queue.isEmpty()) {
            int size=queue.size();
            List<Integer> subList= new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current=queue.poll();
                subList.add(current.val);
                if (current.left!=null) {
                    queue.offer(current.left);
                }
                if (current.right!=null) {
                    queue.offer(current.right);
                }
            }
            result.add(0,subList);
        }
        return result;
    }
}