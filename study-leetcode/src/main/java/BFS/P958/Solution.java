package BFS.P958;

import CommonUtils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断是否是完全二叉树
 * 关键点：层序遍历判断是否出现过Null
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        // 层序遍历
        if (root == null) {
            return true;
        }
        // LinkedList做队列的话支持添加null元素，而ArrayDeque不支持添加null
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean flag = false;
        while (!queue.isEmpty()){
            int curCount = queue.size();
            for (int i = 0; i < curCount; i++){
                TreeNode curNode = queue.poll();
                if (curNode != null){
                    // 如果在这之前出现过null节点，根据完全二叉树的性质，可以判断结果了
                    if (flag) {
                        return false;
                    }
                    queue.add(curNode.left);
                    queue.add(curNode.right);
                }else{ // 记录出现过null节点
                    flag = true;
                }
            }
        }
        return true;
    }
}
