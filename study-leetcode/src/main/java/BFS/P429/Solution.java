package BFS.P429;

import Tree.Node;

import java.util.*;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue= new LinkedList<>();

        List<List<Integer>> result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();

        if (root!=null) {
            queue.offer(root);
        }
        Integer size=queue.size();

        while (!queue.isEmpty()){

            Node node=queue.poll();
            temp.add(node.val);

            //增加元素
            if (node.children!=null) {
                for (Node child : node.children) {
                    queue.offer(child);
                }
            }
            if (temp.size()==size) {
                result.add(new ArrayList<>(temp));
                temp.clear();
                size=queue.size();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> temp=new ArrayList<>();
        temp.add(1);
        temp.clear();
        temp.add(2);
        System.out.println(temp.size());
    }
}