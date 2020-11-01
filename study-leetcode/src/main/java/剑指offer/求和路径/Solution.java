package 剑指offer.求和路径;

import CommonUtils.TreeNode;
import CommonUtils.TreeNodeUtils;

import java.util.Deque;
import java.util.LinkedList;

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
    private int result=0;
    public int pathSum(TreeNode root, int sum) {
        Deque<TreeNode> deque= new LinkedList<>();
        TreeNode cur=root;
        while (cur != null || !deque.isEmpty()) {
            while (cur != null) {
                deque.offerLast(cur);
                cur=cur.left;
            }
            TreeNode top=deque.pollLast();
            dfs(top,sum);
            cur=top.right;
        }
        return result;
    }
    private void dfs(TreeNode root,int left){
        if (root.val==left) {
            result++;
        }
        if (root.left!=null) {
            dfs(root.left,left-root.val);
        }
        if (root.right!=null) {
            dfs(root.right,left-root.val);
        }
    }

    public static void main(String[] args) {
        TreeNode root= TreeNodeUtils.stringToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,5,1]");
        System.out.println(new Solution().pathSum(root, 22));

        TreeNode root1= TreeNodeUtils.stringToTreeNode("[1,-2,-3,1,3,-2,null,-1]");
        System.out.println(new Solution().pathSum(root1, -1));
    }
}