package DepthFirstSearch.P108;

import WaitingCollect.P104.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 递归分而治之
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTRecur(nums,0,nums.length-1);
    }
    public TreeNode sortedArrayToBSTRecur(int[] nums,int start,int end){
        if (start>end) {
            return null;
        }
        if (start==end) {
            return new TreeNode(nums[start]);
        }
        int mid=(start+end)/2;
        TreeNode treeNodeLeft=sortedArrayToBSTRecur(nums,start,mid-1);
        TreeNode treeNodeRight=sortedArrayToBSTRecur(nums,mid+1,end);

        TreeNode treeNodeMid=new TreeNode(nums[mid]);
        treeNodeMid.left=treeNodeLeft;
        treeNodeMid.right=treeNodeRight;

        return treeNodeMid;
    }

    public static void main(String[] args) {
        int[] ints={-10,-3,0,5,9};
        new Solution().sortedArrayToBST(ints);
    }
}