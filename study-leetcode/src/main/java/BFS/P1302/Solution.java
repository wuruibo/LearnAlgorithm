package BFS.P1302;

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
 *
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * Output: 15
 */
class Solution {
     public int deepestLeavesSum(TreeNode root) {
         Queue<TreeNode> queue= new LinkedList<>();
         queue.offer(root);

         int result=0;
         while (!queue.isEmpty()) {
             int size=queue.size();
             int temp=0;
             for (int i = 0; i < size; i++) {
                 TreeNode current=queue.poll();
                 temp+=current.val;

                 if (current.left!=null) queue.offer(current.left);
                 if (current.right!=null) queue.offer(current.right);
             }
             result=temp;
         }

         return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode= TreeNodeUtils.stringToTreeNode("[1,2,3,4,5,null,6,7,null,null,null,null,8]");
        System.out.println(new Solution().deepestLeavesSum(treeNode));
    }
}