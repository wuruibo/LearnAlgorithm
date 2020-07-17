package Contest.Contest11.Problem2;

import CommonUtils.TreeNode;

import java.util.ArrayList;
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
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root==null) {
            return true;
        }
        boolean left=isValidBST(root.left);
        boolean right=isValidBST(root.right);
        //哪几种情况返回false 1.left和right中包含一个false  2.left和right两个都是true
        if (left && right) {
            Integer leftSon=root.left==null?Integer.MIN_VALUE:root.left.val;
            Integer rightSon=root.right==null?Integer.MAX_VALUE:root.right.val;
            if (root.val<rightSon && root.val>leftSon) {
                return true;
            }
        }
        return false;
    }
    public boolean isValidBST1(TreeNode root) {
        List<Integer> result= new ArrayList<>();
        preOrder(root,result);

        for (int i = 0; i < result.size(); i++) {
            Integer left=result.get(i);
            Integer right=result.get(i+1);
            if (left>=right) {
                return false;
            }
        }
        return true;
    }
    private void preOrder(TreeNode root,List<Integer> result){
        if (root==null) {
            return;
        }
        preOrder(root.left,result);
        result.add(root.val);
        preOrder(root.right,result);
    }
}