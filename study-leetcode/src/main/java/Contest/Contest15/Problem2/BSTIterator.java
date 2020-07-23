package Contest.Contest15.Problem2;

import CommonUtils.TreeNode;
import CommonUtils.TreeNodeUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    private List<Integer> result=new ArrayList();
    private int index=0;
    public BSTIterator(TreeNode root) {
        Deque<TreeNode> deque= new ArrayDeque<>();
        TreeNode current=root;
        while (current!=null || !deque.isEmpty()) {
            while (current!=null){
                deque.offerLast(current);
                current=current.left;
            }
            TreeNode left=deque.pollLast();
            result.add(left.val);
            current=current.right;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        return result.get(index++);
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index<result.size();
    }

    public static void main(String[] args) {
        TreeNode treeNode= TreeNodeUtils.stringToTreeNode("[]");
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */