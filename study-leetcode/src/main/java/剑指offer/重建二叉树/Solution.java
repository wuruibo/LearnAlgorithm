package 剑指offer.重建二叉树;

import CommonUtils.TreeNode;

import java.util.Arrays;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length==0){
            return null;
        }
        //找到preorder中的第一个点 利用inorder中的位置分割preorder数组
        int rootValue=preorder[0];
        TreeNode root=new TreeNode(preorder[0]);
        int index=findIndex(inorder, rootValue);
        TreeNode leftNode=buildTree(Arrays.copyOfRange(preorder,1,index+1),Arrays.copyOfRange(inorder,0,index));
        TreeNode rightNode=buildTree(Arrays.copyOfRange(preorder,index+1,preorder.length),Arrays.copyOfRange(inorder,index+1,inorder.length));
        root.left=leftNode;
        root.right=rightNode;
        return root;
    }
    private int findIndex(int[] inorder,int rootValue){
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i]==rootValue){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }
}