package CommonUtils;

import P104.TreeNode;

/**
 * @autor yeqiaozhu.
 * @date 2019-09-29
 */
public class TreeNodeUtils {
    public static TreeNode buildTreeNodeUsingArray(int[] ints){
        if (ints == null || ints.length==0) {
            return null;
        }
        TreeNode root=new TreeNode(ints[0]);
        for (int i = 1; i < ints.length; i++) {
            TreeNode treeNode=new TreeNode(ints[i]);
            insertTreeNode(root,treeNode);
        }
        return root;
    }
    public static void insertTreeNode(TreeNode root,TreeNode valToInsert){
        if (root.val>valToInsert.val && root.left == null) {
            root.left=valToInsert;
        } else if (root.val<valToInsert.val && root.right ==null) {
            root.right=valToInsert;
        } else {
            if(root.val<valToInsert.val){
                insertTreeNode(root.right,valToInsert);
            } else {
                insertTreeNode(root.left,valToInsert);
            }
        }
    }
    public static void insertTreeNodeJustBinary(TreeNode root,TreeNode valToInsert){
        if (root == null) {

        }
    }

    public static void main(String[] args) {
        int[] ints={3,9,20,15,7};
        TreeNodeUtils.buildTreeNodeUsingArray(ints);
    }
}
