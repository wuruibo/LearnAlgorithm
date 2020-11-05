package Tree.P1430;

import CommonUtils.TreeNode;

/**
 * 前序遍历的典型
 * 先判断当前节点和arr当前索引元素是否相等 相等的话继续往下
 */
class Solution {
     public boolean isValidSequence(TreeNode root, int[] arr) {
        return checkValidSequence(root,arr,0);
    }

    private boolean checkValidSequence(TreeNode root,int[] arr,int index){
        // 数值不相同，返回false
        if (root == null || root.val != arr[index]){
            return false;
        }
        // 最后一个元素的特判，必须是叶子节点
        if (index == arr.length - 1){
            return root.left == null && root.right == null;
        }
        // 递归判断左右子树
        return checkValidSequence(root.left,arr,index+1) || checkValidSequence(root.right,arr,index+1);
    }
}