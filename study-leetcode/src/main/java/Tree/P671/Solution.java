package Tree.P671;

import CommonUtils.TreeNode;

/**
 * java，问题可以转化为求左右子树的最小值，如果左右子树最小值都大于根节点的值取较小的值。其他情况取左右子树较大的值。
 * @author yeqiaozhu
 */
public class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        return dfs(root, root.val);
    }

    public int dfs(TreeNode root, int val) {
        if (root == null) {
            return -1;
        }
        if (root.val > val) {
            return root.val;
        }
        int l = dfs(root.left, val);
        int r = dfs(root.right, val);
        if (l > val && r > val) {
            return Math.min(l,r);
        }
        return Math.max(l,r);
    }
}
