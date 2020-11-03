package Tree.P894;

import CommonUtils.TreeNode;

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
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> ans = new ArrayList<>();
        if (N % 2 == 0) {
            return ans;
        }
        if (N == 1) {
            TreeNode head = new TreeNode(0);
            ans.add(head);
            return ans;
        }
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - 1 - i);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode head = new TreeNode(0);
                    head.left = l;
                    head.right = r;
                    ans.add(head);
                }
            }
        }
        return ans;
    }
}