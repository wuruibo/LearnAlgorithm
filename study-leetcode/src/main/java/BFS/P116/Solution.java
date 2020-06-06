package BFS.P116;

import CommonUtils.Node;

import java.util.LinkedList;
import java.util.Queue;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if (root==null) {
            return null;
        }
        //定义队列 用于存储节点
        Queue<Node> queue= new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            //当前深度级别 需要遍历次数
            int currentSize=queue.size();
            //定义当前级别的横向链表的尾部
            Node tail=null;
            for (int i = 0; i < currentSize; i++) {
                //拿一个节点出来
                Node node=queue.poll();
                //进行节点的拼接
                if (tail==null) {
                    tail=node;
                }else {
                    //第一步将节点 添加上去
                    tail.next=node;
                    //第二步 更新尾节点
                    tail=node;
                }
                //将节点push进去
                if (node.left!=null) {
                    queue.offer(node.left);
                }
                if (node.right!=null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {

    }
}