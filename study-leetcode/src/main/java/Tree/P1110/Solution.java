package Tree.P1110;

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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result=new ArrayList<>();
        if (root==null) {
            return result;
        }
        dfs(root, result,to_delete);
        if (!containsKey(to_delete,root.val)) {
            result.add(root);
        }else {
            if (root.left!=null) {
                result.add(root.left);
            }
            if (root.right!=null) {
                result.add(root.right);
            }
        }
        return result;
    }
    private void dfs(TreeNode root,List<TreeNode> temp,int[] to_delete){
        if (root==null) {
            return;
        }
        TreeNode[] next=new TreeNode[]{root.left,root.right};
        for (int i = 0; i < next.length; i++) {
           dfs(next[i],temp,to_delete);
        }
        for (int j = 0; j < next.length; j++) {
            if (next[j]!=null && containsKey(to_delete,next[j].val)) {
                if (next[j].left!=null) {
                    temp.add(next[j].left);
                }
                if (next[j].right!=null) {
                    temp.add(next[j].right);
                }
                if (j==0) {
                    root.left=null;
                }else {
                    root.right=null;
                }
            }
        }
    }
    private boolean containsKey(int[] to_delete,int target){
        for (int i : to_delete) {
            if (i==target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root= TreeNodeUtils.stringToTreeNode("[1,2,3,4,5,6,7]");
        System.out.println(new Solution().delNodes(root, new int[]{3, 5}));
    }
}