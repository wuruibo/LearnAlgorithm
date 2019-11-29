package BFS.P103;

import CommonUtils.TreeNodeUtils;
import WaitingCollect.P104.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BFS Using Queue
 * @autor yeqiaozhu.
 * @date 2019-11-23
 */
public class UsingQueue {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result= new ArrayList<>();
        if (root==null) {
            return result;
        }
        //定义一个queue 并初始化
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        //定义倒还是顺序的flag false表示倒 true表示顺
        boolean flag=true;
        //开始循环 bfs
        while (!queue.isEmpty()) {
            //当前深度的节点数量
            int currentSize=queue.size();
            //定义一个当前深度的数组 将元素顺序或者倒序存入
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < currentSize; i++) {
                //拿到一个节点
                TreeNode treeNode = queue.poll();

                if (flag) {
                    temp.add(treeNode.val);
                } else {
                    temp.add(0, treeNode.val);
                }
                //同时将这个级别下面的元素也加入进去队列中
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            //改变顺序
            flag=!flag;
            //将当前级别构造的数组加入
            result.add(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode= TreeNodeUtils.stringToTreeNode("[3,9,20,null,null,15,7]");
        new Solution().zigzagLevelOrder(treeNode);
    }
}