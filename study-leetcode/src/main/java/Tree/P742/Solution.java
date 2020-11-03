package Tree.P742;

import CommonUtils.TreeNode;
import CommonUtils.TreeNodeUtils;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int findClosestLeaf(TreeNode root, int k) {
        Deque<TreeNode> deque= new LinkedList<>();
        TreeNode cur=root;
        while (cur != null || !deque.isEmpty()) {
            while (cur != null) {
                deque.offerLast(cur);
                cur=cur.left;
            }
            TreeNode top=deque.pollLast();
            if (top.val==k) {
                return closedHeight(top)[0];
            }
            cur=top.right;
        }
        return -1;
    }
    public int[] closedHeight(TreeNode root){
        if (root.left==null && root.right==null) {
            return new int[]{root.val,0};
        }
        int[] leftChild=null;
        int[] rightChild=null;
        if (root.left!=null) {
            leftChild=closedHeight(root.left);
        }
        if (root.right!=null) {
            rightChild=closedHeight(root.right);
        }
        if (leftChild==null) {
            rightChild[1]++;
            return rightChild;
        }else if (rightChild==null){
            leftChild[1]++;
            return leftChild;
        }else {
            leftChild[1]++;
            rightChild[1]++;
            return rightChild[1] < leftChild[1] ? rightChild : leftChild;
        }
    }

    public static void main(String[] args) {
        TreeNode root= TreeNodeUtils.stringToTreeNode("[1,2,3,4,null,null,null,5,null,6]");
        System.out.println(new Solution().findClosestLeaf(root, 2));

        TreeNode root1= TreeNodeUtils.stringToTreeNode("[1]");
        System.out.println(new Solution().findClosestLeaf(root1, 1));

        TreeNode root2= TreeNodeUtils.stringToTreeNode("[1,2,3,4,null,null,null,5,null,6]");
        System.out.println(new Solution().findClosestLeaf(root2, 2));

        TreeNode root3= TreeNodeUtils.stringToTreeNode("[1,2,3,null,null,4,5,6,null,null,7,8,9,10]");
        System.out.println(new Solution().findClosestLeaf(root3, 4));
    }
}