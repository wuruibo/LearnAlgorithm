package Tree.P1120;

import CommonUtils.TreeNode;

/**
 * 给你一棵二叉树的根节点 root，找出这棵树的 每一棵 子树的 平均值 中的 最大 值。
 *
 * 子树是树中的任意节点和它的所有后代构成的集合。
 *
 * 树的平均值是树中节点值的总和除以节点数。
 *
 *
 * 输入：[5,6,1]
 * 输出：6.00000
 * 解释：
 * 以 value = 5 的节点作为子树的根节点，得到的平均值为 (5 + 6 + 1) / 3 = 4。
 * 以 value = 6 的节点作为子树的根节点，得到的平均值为 6 / 1 = 6。
 * 以 value = 1 的节点作为子树的根节点，得到的平均值为 1 / 1 = 1。
 * 所以答案取最大值 6。
 *
 */
class Solution {
    double res = 0;

    public double maximumAverageSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return res;
    }

    private int[] helper(TreeNode root) {
        int[] arr = new int[2];
        if (root == null) {
            return arr;
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        //设置当前树的元素和
        arr[0] = left[0] + right[0] + root.val;
        //设置节点个数
        arr[1] = left[1] + right[1] + 1;
        //更新平均值
        res = Math.max(res,(double) arr[0] / arr[1]);
        return arr;
    }
}
