package DynamicProgramming.P95;

import CommonUtils.TreeNode;
import CommonUtils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 *
 *
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
    public List<TreeNode> generateTrees(int n) {
        if (n==0) {
            return new ArrayList<>();
        }
        return recursive(1,n);
    }
    private List<TreeNode> recursive(int start,int end){
        List<TreeNode> result=new ArrayList<>();
        if (start>end) {
            result.add(null);
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftList=recursive(start,i-1);
            List<TreeNode> rightList=recursive(i+1,end);

            for (TreeNode left : leftList) {

                for (TreeNode right : rightList) {
                    TreeNode root=new TreeNode(i);
                    root.left=left;
                    root.right=right;
                    result.add(root);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new Solution().generateTrees(3).stream().forEach(list->{
            TreeNodeUtils.preorder(list);
            System.out.println();
        });
    }
}