package Stack.P144;

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result= new ArrayList<>();
        recursive(root,result);
        return result;
    }
    private void recursive(TreeNode root,List<Integer> temp){
        if (root==null) {
            return;
        }
        temp.add(root.val);
        recursive(root.left,temp);
        recursive(root.right,temp);
    }

    public static void main(String[] args) {
        TreeNode treeNode= TreeNodeUtils.stringToTreeNode("[1,null,2,3]");
        new Solution().preorderTraversal(treeNode).stream().forEach(integer -> System.out.print(integer));
    }
}