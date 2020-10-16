package Tree.P449;

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

    private final String code="#";
    /**
     * bfs序列化二叉树
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        StringBuilder result=new StringBuilder();
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current=queue.poll();
                if (current==null) {
                    result.append(code);
                }else {
                    result.append(current.val);
                    queue.offer(current.left);
                    queue.offer(current.right);
                }
                result.append(",");
            }
        }
        return result.substring(0,result.length()-1);
    }
    /**
     * 反bfs构造二叉树
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        String[] strings=data.split(",");
        //先添加root节点
        String rootVal=strings[0];
        if (rootVal.equals(code)) {
            return null;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode root=new TreeNode(Integer.parseInt(rootVal));
        queue.offer(root);

        int index=1;
        while (!queue.isEmpty()) {
            TreeNode treeNode=queue.poll();

            if (index<strings.length && !strings[index].equals(code)) {
                TreeNode left=new TreeNode(Integer.parseInt(strings[index]));
                treeNode.left=left;
                queue.offer(left);
            }
            index++;
            if (index<strings.length && !strings[index].equals(code)) {
                TreeNode right=new TreeNode(Integer.parseInt(strings[index]));
                treeNode.right=right;
                queue.offer(right);
            }
            index++;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode= TreeNodeUtils.stringToTreeNode("[1,2,3,null,null,4,5]");
        String serialized=new Codec().serialize(treeNode);
        TreeNode root=new Codec().deserialize(serialized);
    }


}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;