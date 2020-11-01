package Tree.合法二叉搜索树;

import CommonUtils.TreeNode;

/**
 * 原理：二叉搜索树的中序遍历是递增的
 *
 * 定义一个pre节点保存当前节点的前一个节点，比较大小，不是严格递增即返回false
 * @author yqz
 */
public class BST {
    TreeNode pre ;
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true ;
        }
        Boolean L = isValidBST(root.left);
        if(pre != null && pre.val >= root.val) {
            return false ;
        }
        pre = root ;
        Boolean R = isValidBST(root.right) ;
        return L && R ;
    }
}
