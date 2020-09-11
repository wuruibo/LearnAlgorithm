package Tree.剑指offer32;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue=new LinkedList<>();
        if (root!=null) {
            queue.offer(root);
        }
        List<List<Integer>> result= new ArrayList<>();
        Integer level=0;
        while (!queue.isEmpty()) {
            int size=queue.size();
            List<Integer> param=new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode current=queue.pollFirst();
                if ((level&1)==0) {
                    param.add(current.val);
                }else {
                    param.add(0,current.val);
                }

                //添加元素
                if (current.left!=null) {
                    queue.offerLast(current.left);
                }
                if (current.right!=null) {
                    queue.offerLast(current.right);
                }
            }
            result.add(param);
            level++;
        }
        return result;
    }
}