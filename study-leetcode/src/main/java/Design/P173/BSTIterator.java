package Design.P173;

import Design.P173.BSTIterator;
import CommonUtils.TreeNode;
import CommonUtils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    private List<Integer> result= new ArrayList<>();
    private Integer index=0;
    public BSTIterator(TreeNode root) {
        inOrderStack(root);
    }
    private void inOrderStack(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        TreeNode current=root;

        while (current!=null || !stack.isEmpty()){
            while (current!=null){
                stack.push(current);
                current=current.left;
            }
            current=stack.pop();
            result.add(current.val);
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
        TreeNode root= TreeNodeUtils.stringToTreeNode("[7,3,15,null,null,9,20]");
        BSTIterator iterator=new BSTIterator(root);
        while (iterator.hasNext()) System.out.println(iterator.next());
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */