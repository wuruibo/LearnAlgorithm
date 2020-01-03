package Stack.P145;

import CommonUtils.TreeNode;
import CommonUtils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [3,2,1]
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result= new ArrayList<>();
        postOrderRecur(root,result);
        return result;
    }
    private void postOrderRecur(TreeNode root,List<Integer> temp){
        if (root==null) {
            return;
        }
        postOrderRecur(root.left,temp);
        postOrderRecur(root.right,temp);
        temp.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode treeNode= TreeNodeUtils.stringToTreeNode("[1,null,2,3]");
        new Solution().postorderTraversal(treeNode).stream().forEach(integer -> System.out.print(integer));
    }
}