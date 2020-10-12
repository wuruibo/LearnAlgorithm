package Tree.P404;

import CommonUtils.TreeNode;

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左
        int leftValue = sumOfLeftLeaves(root.left);
        // 右
        int rightValue = sumOfLeftLeaves(root.right);
        // 中
        int midValue = 0;
        if (root.left!=null && root.left.left==null && root.left.right==null) {
            midValue = root.left.val;
        }
        int sum = midValue + leftValue + rightValue;
        return sum;
    }
}