package Tree.P776;

import CommonUtils.TreeNode;

/**
 *  1， 如果root.val <= V，那么root一定会在分割后的左子树中，V比root大，所以肯定要到右子树中看看从哪里分割了；
 *  2，右子树的分割，分割成两部分，较小的部分都比V小，所以作为左子树root的“新的”右子树；较大的部分直接独立了；
 *  3，如果root.val > V, 那么root一定会在被分割后的右子树中，V比root小，所以肯定要去左子树里面看看从哪里分割；
 *  4，左子树的分割，分割成两部分，较小的部分都比V小，直接独立了，较大的部分要作为“新的”（右子树）root的左子树。
 */
class Solution {
    public TreeNode[] splitBST(TreeNode root, int V) {
        if (root == null) {
            return new TreeNode[2];
        }
        if (root.val <= V) {
            // root 以及 root的左子树必然 <= v 但是root 的右子树有可能有大于v的节点
            // 所以这地方还得把root.right 划分一下
            TreeNode[] right = splitBST(root.right, V);
            // 划分完以后把较小的子树置为root的右子树
            root.right = right[0];
            right[0] = root;
            return right;
        } else {
            // root 以及 root的右子树必然 > v 但是root 的左子树还可能存在大于v的节点
            // 所以这地方依然需要再划分一下root.left
            TreeNode[] left = splitBST(root.left, V);
            // 划分完以后把较大的子树（大于v）置为root的左子树
            root.left = left[1];
            left[1] = root;
            return left;
        }
    }
}