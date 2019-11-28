package BFS.P199;

import CommonUtils.TreeNodeUtils;
import P104.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * using DFS
 * @autor yeqiaozhu.
 * @date 2019-11-28
 */
public class UsingDFS {
    private List<Integer> result= new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root,0);
        return result;
    }

    public void dfs(TreeNode root,int depth){
        if (root==null) {
            return;
        }
        if (result.size()==depth) {
            result.add(root.val);
        }
        dfs(root.right,depth+1);
        dfs(root.left,depth+1);
    }

    public static void main(String[] args) {
        TreeNode treeNode= TreeNodeUtils.stringToTreeNode("[1,2,3,null,5,null,4]");
        new UsingDFS().rightSideView(treeNode);

        TreeNode treeNode1= TreeNodeUtils.stringToTreeNode("[1,2,3,4]");
        new UsingDFS().rightSideView(treeNode1);
    }
}
