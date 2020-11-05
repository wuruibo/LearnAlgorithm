package Tree.P426;

import CommonUtils.Node;

/**
 * 中序遍历dfs
 * @author yeqiaozhu
 * @date today
 */
public class Solution {
    /**
     * 头指针
     */
    private Node head;

    /**
     * 前面一个指针
     */
    private Node pre;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        inOrder(root);
        pre.right = head;
        head.left = pre;
        return head;
    }

    private void inOrder(Node node) {
        if (null == node) return;
        inOrder(node.left);
        if (head == null) head = node;
        if (pre != null) {
            pre.right = node;
            node.left = pre;
        }
        pre = node;
        inOrder(node.right);
    }
}
