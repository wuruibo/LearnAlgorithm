package DepthFirstSearch.P117;

import CommonUtils.Node;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        Node dummyHead = new Node();
        Node first = root;
        while(first != null) {
            Node cur = first;
            Node tail = dummyHead;
            while (cur != null) {
                if (cur.left != null) {
                    tail.next = cur.left;
                    tail = cur.left;
                }
                if (cur.right != null) {
                    tail.next = cur.right;
                    tail = cur.right;
                }
                cur = cur.next;
            }
            first = dummyHead.next; // go next depth
            dummyHead.next = null;
        }
        return root;
    }
}