package BST.P297;

import CommonUtils.TreeNode;
import CommonUtils.TreeNodeUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 利用的原理是
 *
 * 中序遍历可以确定二叉树的造型
 *
 * 先序和后序 要结合才能确定二叉树的造型
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    StringBuilder serialized=new StringBuilder();
    // Encodes a tree to a single string. 直接用中序遍历
    public String serialize(TreeNode root) {
        midRecursive(root);

        return serialized.deleteCharAt(serialized.length()-1).toString();
    }
    private void midRecursive(TreeNode root){
        if (root==null) {
            serialized.append("#,");
            return;
        }
        serialized.append(root.val+",");
        midRecursive(root.left);
        midRecursive(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue=new LinkedList(Arrays.asList(data.split(",")));

        return buildTree(queue);
    }
    private TreeNode buildTree(Queue<String> queue){


        String val=queue.poll();
        if (val.equals("#")) {
            return null;
        }
        TreeNode root=new TreeNode(Integer.valueOf(val));
        //返回左树构造完毕的结果
        TreeNode left=buildTree(queue);
        //返回右树构造完毕的结果
        TreeNode right=buildTree(queue);

        root.left=left;
        root.right=right;

        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode= TreeNodeUtils.stringToTreeNode("[1,2,3,null,null,4,5]");
        String serialized=new Codec().serialize(treeNode);
        System.out.println(serialized);
        System.out.println(new Codec().deserialize(serialized));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));