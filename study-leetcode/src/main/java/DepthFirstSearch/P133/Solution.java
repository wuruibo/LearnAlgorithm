package DepthFirstSearch;

import java.util.*;
import java.util.stream.Collectors;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}



class Solution {
    public Node cloneGraph(Node node) {
        Node parent=new Node(node.val);
        dfs(node,parent,new HashSet<>());
        return parent;
    }
    private void dfs(Node node, Node parent, Set<Integer> visited){
        //先拷贝加入 当前父节点完成任务了
        parent.neighbors=node.neighbors
                .stream()
                .map(n-> new Node(n.val))
                .collect(Collectors.toList());
        visited.add(node.val);

        //继续往下递归
        for (int i = 0; i < node.neighbors.size(); i++) {
            Node nextNode=node.neighbors.get(i);
            Node nextParent=parent.neighbors.get(i);
            if (!visited.contains(nextNode.val)) {
                dfs(nextNode,nextParent,visited);
            }
        }
    }
    public Node cloneGraphDfs(Node node) {
        if (node == null) {
            return node;
        }
        Map<Integer, Node> map = new HashMap<>();
        return cloneGrapthHelper(node, map);
    }

    private Node cloneGrapthHelper(Node node, Map<Integer, Node> map) {
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        //生成当前节点
        Node n = new Node(node.val);
        map.put(node.val, n);
        //添加它的所有邻居节点
        for (Node temp : node.neighbors) {
            n.neighbors.add(cloneGrapthHelper(temp, map));
        }
        return n;
    }


    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        System.out.println(list.stream().collect(Collectors.toList())==list);
    }
}