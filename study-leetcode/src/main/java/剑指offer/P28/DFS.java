package 剑指offer.P28;

import CommonUtils.TreeNode;

/**
 * @author yeqiaozhu
 * 需要满足：
 * 1. L.val=R.val
 * 2. L.left 和 R.right对称
 * 3. R.left 和 L.right对称
 */
public class DFS {
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }
    boolean recur(TreeNode L, TreeNode R) {
        if(L == null && R == null) {
            return true;
        }
        if(L == null || R == null || L.val != R.val) {
            return false;
        }
        return recur(L.left, R.right) && recur(L.right, R.left);
    }
}
