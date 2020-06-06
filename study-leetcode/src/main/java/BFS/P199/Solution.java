package BFS.P199;

import CommonUtils.TreeNodeUtils;
import CommonUtils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
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
    public List<Integer> rightSideView(TreeNode root) {
        if (root==null) {
            return result;
        }
        bfs(root);
        return result;
    }
    public void bfs(TreeNode root){
        //1.定义queue
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        //2.开始循环
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            //将当前队列的最上层的元素加入result
            result.add(((LinkedList<TreeNode>) queue).peekLast().val);
            for (int i = 0; i < currentSize; i++) {
                //3.从队列中弹出一个元素
                TreeNode treeNode = queue.poll();

                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode= TreeNodeUtils.stringToTreeNode("[1,2,3,null,5,null,4]");
        new Solution().rightSideView(treeNode);

        TreeNode treeNode1= TreeNodeUtils.stringToTreeNode("[1,2,3,4]");
        new Solution().rightSideView(treeNode1);
    }
}