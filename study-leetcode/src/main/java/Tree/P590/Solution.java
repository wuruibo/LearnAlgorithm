package Tree.P590;

import Tree.Node;

import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> postorder(Node root) {
        List<Integer> result= new ArrayList<>();
        postOrderRecur(root,result);
        return result;
    }
    private void postOrderRecur(Node root,List<Integer> temp){
        if (root==null) {
            return;
        }
        List<Node> list=root.children;
        for (Node node : list) {
            postOrderRecur(node,temp);
        }
        temp.add(root.val);
    }
}