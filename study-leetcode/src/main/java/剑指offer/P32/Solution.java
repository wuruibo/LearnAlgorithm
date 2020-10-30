package 剑指offer.P32;

import CommonUtils.TreeNode;
import CommonUtils.TreeNodeUtils;

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
    private List<List<Integer>> result= new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null) {
            return result;
        }
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root,int depth){
        addDepthList(root,depth);
        if (root.left!=null) {
            dfs(root.left,depth+1);
        }
        if (root.right!=null) {
            dfs(root.right,depth+1);
        }
    }
    private void addDepthList(TreeNode root,int depth){
        if (depth<result.size()){
            List<Integer> depthList=result.get(depth);
            depthList.add(root.val);
            result.set(depth,depthList);
        }else {
            List<Integer> depthList=new ArrayList<>();
            depthList.add(root.val);
            result.add(depthList);
        }
    }

    public static void main(String[] args) {
        TreeNode root=TreeNodeUtils.stringToTreeNode("[3,9,20,null,null,15,7]");
        new Solution().levelOrder(root);
    }
}