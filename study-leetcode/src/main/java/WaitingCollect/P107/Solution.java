package WaitingCollect.P107;

import CommonUtils.TreeNodeUtils;
import WaitingCollect.P104.TreeNode;

import java.util.LinkedList;
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
    private List<List<Integer>> result= new LinkedList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        levelOrderBottomRecur(root,0);
        return result;
    }

    /**
     * 多定义一个深度 同一深度的放到同一个数组下
     * @param root
     * @return
     */
    public void levelOrderBottomRecur(TreeNode root,int depth){
        if (root==null) {
            return;
        }
        if (depth>=result.size()) {
            result.add(0,new LinkedList<>());
        }
        levelOrderBottomRecur(root.left,depth+1);
        levelOrderBottomRecur(root.right,depth+1);

        result.get(result.size()-depth-1).add(root.val);
    }

    public static void main(String[] args) {
        String string="[3,9,20,null,null,15,7]";
        String string1="[1,2,3,4,null,null,5]";
        TreeNode treeNode=TreeNodeUtils.stringToTreeNode(string);
        TreeNode treeNode1=TreeNodeUtils.stringToTreeNode(string1);
        new Solution().levelOrderBottom(treeNode);
        new Solution().levelOrderBottom(treeNode1);
    }
}