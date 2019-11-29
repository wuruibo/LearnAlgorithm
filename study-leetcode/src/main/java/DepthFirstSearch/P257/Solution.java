package DepthFirstSearch.P257;

import CommonUtils.TreeNodeUtils;
import WaitingCollect.P104.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 借助队列
 */
class Solution {
    private List<String> result= new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root==null) {
            return result;
        }
        binaryTreePathsBack(new StringBuilder().append(root.val),root);
        return result;
    }
    public void binaryTreePathsBack(StringBuilder temp,TreeNode root){
        if (root==null) {
            return;
        }
        if (root.left==null && root.right==null) {
            result.add(temp.toString());
            return;
        }
        Queue<TreeNode> queue= new LinkedList<>();

        if (root.left!=null)  queue.offer(root.left);
        if (root.right!=null)  queue.offer(root.right);

        int beforeIndex=temp.length();
        while (queue.size()!=0){
            TreeNode treeNode=queue.poll();
            temp.append("->"+treeNode.val);
            binaryTreePathsBack(temp,treeNode);
            temp.delete(beforeIndex,temp.length());
        }
    }

    public static void main(String[] args) {
        StringBuilder stringBuilder=new StringBuilder("1");
        int temp=stringBuilder.length();
        stringBuilder.append("->"+2);

        stringBuilder.delete(temp,stringBuilder.length());
        TreeNode treeNode=TreeNodeUtils.stringToTreeNode("[1,2,3,5]");
        new Solution().binaryTreePaths(treeNode);
    }
}