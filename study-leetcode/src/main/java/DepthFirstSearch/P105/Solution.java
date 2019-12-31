package DepthFirstSearch.P105;

import CommonUtils.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 */
class Solution {
    int[] preorder;
    int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder=preorder;
        this.inorder=inorder;

        return buildTreeDFS(0,inorder.length-1,0);
    }
    private TreeNode buildTreeDFS(int inorderStart,int inorderend,int preorderStart){
        if (inorderStart>inorderend || preorderStart>preorder.length-1) {
            return null;
        }
        //找到分割点的位置
        TreeNode root=new TreeNode(preorder[preorderStart]);
        int index=0;
        for (int i = inorderStart; i <= inorderend; i++) {
            if (preorder[preorderStart]==inorder[i]) {
                index=i;
            }
        }
        //左边画个龙
        TreeNode left=buildTreeDFS(inorderStart,index-1,preorderStart+1);
        //右边画个圆
        TreeNode right=buildTreeDFS(index+1,inorderend,preorderStart+index-inorderStart+1);
        //鲤鱼跃龙门
        root.left=left;
        root.right=right;

        return root;
    }

    public static void main(String[] args) {
        int[] inorder={9,3,15,20,7};
        int[] preorder={3,9,20,15,7};
        new Solution().buildTree(preorder,inorder);
    }
}