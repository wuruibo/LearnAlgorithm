package Contest.Contest3.Problem3;

import CommonUtils.TreeNode;
import CommonUtils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private Integer count=0;
    public int pseudoPalindromicPaths (TreeNode root) {
        if (root==null) return 0;
        backtracking(root, new ArrayList<>());

        return count;
    }
    private void backtracking(TreeNode root, List<Integer> list){
        if (root.left==null && root.right==null) {
            list.add(root.val);
            Set<Integer> set= new HashSet<>();
            for (Integer integer : list) {
                if (!set.add(integer)) {
                    set.remove(integer);
                }
            }
            if (set.size()<=1) count++;
            list.remove(list.size()-1);
            return;
        }
        if (root.left!=null) {
            list.add(root.val);
            backtracking(root.left,list);
            list.remove(list.size()-1);
        }
        if (root.right!=null) {
            list.add(root.val);
            backtracking(root.right,list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode=TreeNodeUtils.stringToTreeNode("[2,3,1,3,1,null,1]");
        System.out.println(new Solution().pseudoPalindromicPaths(treeNode));


        TreeNode treeNode1=TreeNodeUtils.stringToTreeNode("[2,1,1,1,3,null,null,null,null,null,1]");
        System.out.println(new Solution().pseudoPalindromicPaths(treeNode1));


        TreeNode treeNode2=TreeNodeUtils.stringToTreeNode("[9]");
        System.out.println(new Solution().pseudoPalindromicPaths(treeNode2));
    }
}