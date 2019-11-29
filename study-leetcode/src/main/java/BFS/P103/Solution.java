package BFS.P103;

import CommonUtils.TreeNodeUtils;
import WaitingCollect.P104.TreeNode;

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
 *
 */
class Solution {
    //定义从左到右遍历顺序的栈 入栈的时候记录列表 出栈的时候记录从右到左的记录到另一个栈
    Stack<TreeNode> firstStack=new Stack<>();
    //定义另一个stack两个stack轮换
    Stack<TreeNode> secondStack=new Stack<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result= new ArrayList<>();
        if (root==null) {
            return result;
        }
        //录入初始值
        firstStack.add(root);
        //开始循环 除非两栈都空了不然不退循环
        while (firstStack.size()!=0 || secondStack.size()!=0){
            List<Integer> temp=new ArrayList<>();
            if (firstStack.size()!=0) {
                while(firstStack.size()!=0) {
                    //持续出栈并记录到list中
                    TreeNode treeNode = firstStack.pop();
                    temp.add(treeNode.val);

                    //将当前出栈的节点的右左放置到second中
                    if (treeNode.left!=null) {
                        secondStack.add(treeNode.left);
                    }
                    if (treeNode.right!=null) {
                        secondStack.add(treeNode.right);
                    }
                }
            }else {
                while (secondStack.size()!=0){
                    TreeNode treeNode=secondStack.pop();
                    temp.add(treeNode.val);

                    if (treeNode.right!=null) {
                        firstStack.add(treeNode.right);
                    }
                    if (treeNode.left!=null) {
                        firstStack.add(treeNode.left);
                    }
                }
            }
            result.add(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode=TreeNodeUtils.stringToTreeNode("[3,9,20,null,null,15,7]");
        new Solution().zigzagLevelOrder(treeNode);
    }
}