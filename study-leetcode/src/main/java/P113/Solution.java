package P113;

import P104.TreeNode;

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
    public List<List<Integer>> pathSum(TreeNode root,int sum){
        List<List<Integer>> result=findPathSum(root,sum);
        result.forEach(integers -> {
            int i=0,j=integers.size()-1;
            while (i<j){
                Integer temp=integers.get(i);
                integers.set(i,integers.get(j));
                integers.set(j,temp);
                i++;j--;
            }
        });
        return result;
    }
    public List<List<Integer>> findPathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result=new ArrayList<>();
        if (root.left==null && root.right==null && root.val==sum) {
            List<Integer> list=new ArrayList<>();
            list.add(root.val);
            result.add(list);
            return result;
        }
        List<List<Integer>> leftResult=findPathSum(root.left,sum-root.val);
        List<List<Integer>> rightResult=findPathSum(root.right,sum-root.val);

        rightResult.forEach(integers -> integers.add(root.val));
        leftResult.stream().forEach(integers -> {
            integers.add(root.val);
            rightResult.add(integers);
        });

        return rightResult;

    }
}