package Tree.P1490;

import java.util.ArrayList;
import java.util.List;

// Definition for a Node.




class Solution {
    public Node cloneTree(Node root) {
        if (root==null) {
            return null;
        }
        List<Node> children=root.children;
        Node current=new Node(root.val);
        for (int i = 0; i < children.size(); i++) {
            Node child=cloneTree(children.get(i));
            current.children.add(child);
        }
        return current;
    }
}
class Node {
    public int val;
    public List<Node> children;


    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};