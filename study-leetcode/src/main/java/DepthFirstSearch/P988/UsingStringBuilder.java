package DepthFirstSearch.P988;

import CommonUtils.TreeNodeUtils;
import WaitingCollect.P104.TreeNode;

/**
 * @autor yeqiaozhu.
 * @date 2019-11-28
 */
public class UsingStringBuilder {
    public String min=null;
    public String smallestFromLeaf(TreeNode root) {
        if (root==null) {
            return "";
        }
        dfs(root,"");

        return min;
    }

    public void dfs(TreeNode root,String temp){
        if (root==null) {
            return;
        }
        String next=(char)(root.val+'a')+temp;

        if (root.left==null && root.right==null) {
            //进行比较并判断大小
            if (min==null) {
                min=next;
            }else {
                min=next.compareTo(min)<0?next:min;
            }
        }
        if (root.left!=null) {
            dfs(root.left,next);
        }
        if (root.right!=null) {
            dfs(root.right,next);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode= TreeNodeUtils.stringToTreeNode("[0,1,2,3,4,3,4]");
        System.out.println(new Solution().smallestFromLeaf(treeNode));

        TreeNode treeNode1= TreeNodeUtils.stringToTreeNode("[25,1,3,1,3,0,2]");
        System.out.println(new Solution().smallestFromLeaf(treeNode1));

        TreeNode treeNode2= TreeNodeUtils.stringToTreeNode("[25,1,null,0,0,1,null,null,null,0]");
        System.out.println(new UsingStringBuilder().smallestFromLeaf(treeNode2));
    }
}
