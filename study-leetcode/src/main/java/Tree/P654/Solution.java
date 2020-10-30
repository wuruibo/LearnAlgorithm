package Tree.P654;

import CommonUtils.TreeNode;

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
    private int[] nums;
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length==0 || nums==null) {
            return null;
        }
        this.nums=nums;
        TreeNode root=new TreeNode(-1);
        dfs(0,nums.length-1,root);
        return root;
    }
    private void dfs(int s,int t,TreeNode current){
        //找到中间节点 当前串最大值 开始构建
        int index=0,max=Integer.MIN_VALUE;
        for (int i = s; i <=t; i++) {
            if (nums[i]>max) {
                max=nums[i];
                index=i;
            }
        }
        current.val=nums[index];
        if (index+1<=t) {
            current.right=new TreeNode(-1);
            dfs(index+1,t,current.right);
        }
        if (index-1>=s) {
            current.left=new TreeNode(-1);
            dfs(s,index-1,current.left);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().constructMaximumBinaryTree(new int[]{3,2,1,6,0,5}));
        System.out.println(new Solution().constructMaximumBinaryTree(new int[]{}));
        System.out.println(new Solution().constructMaximumBinaryTree(new int[]{1}));
    }
}