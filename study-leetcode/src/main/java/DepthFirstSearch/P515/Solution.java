package DepthFirstSearch.P515;

import CommonUtils.TreeNode;
import CommonUtils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * You need to find the largest value in each row of a binary tree.
 *
 * Example:
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * Output: [1, 3, 9]
 *
 *
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        Map<Integer,Integer> result=new HashMap<>();
        dfs(result,root,1);

        List<Integer> temp=new ArrayList<>();
        for (Integer value : result.values()) {
            temp.add(value);
        }

        return temp;

    }
    public void dfs(Map<Integer,Integer> temp, TreeNode root, int depth){
        if (root==null) return;
        temp.put(depth,Math.max(temp.getOrDefault(depth,Integer.MIN_VALUE),root.val));
        dfs(temp,root.left,depth+1);
        dfs(temp,root.right,depth+1);
    }

    public static void main(String[] args) {
        TreeNode treeNode= TreeNodeUtils.stringToTreeNode("[1,3,2,5,3,null,9]");
        new Solution().largestValues(treeNode);
    }
}