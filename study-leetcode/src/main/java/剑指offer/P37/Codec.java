package 剑指offer.P37;

import CommonUtils.TreeNode;
import CommonUtils.TreeNodeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private final String optionNull="#";
    public String serialize(TreeNode root) {
        //bfs序列化二叉树
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        StringBuilder result=new StringBuilder();
        while (!queue.isEmpty()) {
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current=queue.poll();
                if (current==null) {
                    result.append("#,");
                }else {
                    result.append(current.val+",");
                    queue.offer(current.left);
                    queue.offer(current.right);
                }
            }
        }
        return result.substring(0,result.length()-1);
    }

    public TreeNode deserialize(String data) {
        String[] nodes=data.split(",");
        if (nodes[0].equals(optionNull)) {
            return null;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode root=new TreeNode(Integer.valueOf(nodes[0]));
        queue.offer(root);
        int index=1;
        while (!queue.isEmpty()) {
            TreeNode current=queue.poll();
            if (!nodes[index].equals(optionNull)) {
                current.left=new TreeNode(Integer.valueOf(nodes[index]));
                queue.offer(current.left);
            }
            index++;
            if (!nodes[index].equals(optionNull)) {
                current.right=new TreeNode(Integer.valueOf(nodes[index]));
                queue.offer(current.right);
            }
            index++;
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root= TreeNodeUtils.stringToTreeNode("[1,2,3,null,null,4,5]");
        String seriable=new Codec().serialize(root);
        System.out.println(seriable);

        TreeNode root1=new Codec().deserialize(seriable);
        System.out.println(new Codec().serialize(root1));

    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));