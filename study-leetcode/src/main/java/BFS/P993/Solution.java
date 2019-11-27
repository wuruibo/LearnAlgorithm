package BFS.P993;

import CommonUtils.TreeNodeUtils;
import P104.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

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
    //目标结果集
    private Set<Integer> result= new HashSet<>();
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root==null) {
            return false;
        }
        result.add(x);
        result.add(y);
        //定义一个队列
        Queue<TreeNode> queue=new LinkedList<>();
        //插入初始值
        queue.offer(root);

        //开始循环
        while (!queue.isEmpty()){
            int currentSize=queue.size();
            for (int i = 0; i < currentSize; i++) {
                //标志当前节点下的子节点如果已经命中目标值 false未出现 true 已经出现
                boolean flag=false;
                TreeNode treeNode=queue.poll();

                if (treeNode.left!=null) {
                    queue.offer(treeNode.left);
                    //判断当前treeNode的子节点中是否命中
                    flag=result.remove(treeNode.left.val);
                }
                if (treeNode.right!=null) {
                    queue.offer(treeNode.right);
                    if (!flag) {
                         result.remove(treeNode.right.val);
                    }
                }
            }
            if (result.size()==0) {
                return true;
            }else {
                result.add(x);
                result.add(y);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode treeNode= TreeNodeUtils.stringToTreeNode("[1,2,3,4]");
        System.out.println(new Solution().isCousins(treeNode,4,3));

        TreeNode treeNode1=TreeNodeUtils.stringToTreeNode("[1,2,3,null,4,null,5]");
        System.out.println(new Solution().isCousins(treeNode1,5,4));

        TreeNode treeNode2=TreeNodeUtils.stringToTreeNode("[1,2,3,null,4]");
        System.out.println(new Solution().isCousins(treeNode2,2,3));
    }
}