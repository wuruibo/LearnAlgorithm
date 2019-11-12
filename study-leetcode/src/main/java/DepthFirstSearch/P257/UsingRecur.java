package DepthFirstSearch.P257;

import CommonUtils.TreeNodeUtils;
import P104.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor yeqiaozhu.
 * @date 2019-11-12
 */
public class UsingRecur {
    private List<String> reuslt= new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root!=null) {
            binaryTreePathRecur(root,"");
        }
        return reuslt;
    }
    public void binaryTreePathRecur(TreeNode root,String temp){
        if (root.left==null && root.right==null) {
            reuslt.add(temp+root.val);
            return;
        }
        if (root.left!=null) {
            binaryTreePathRecur(root.left,temp+root.val+"->");
        }
        if (root.right!=null) {
            binaryTreePathRecur(root.right,temp+root.val+"->");
        }
    }

    public static void main(String[] args) {

        TreeNode treeNode= TreeNodeUtils.stringToTreeNode("[1,2,3,5]");
        new UsingRecur().binaryTreePaths(treeNode);
    }
}