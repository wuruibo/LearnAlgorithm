package CommonUtils;

import java.util.LinkedList;
import java.util.Queue;

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
    public static void preorder(TreeNode root){
        if (root==null) {
            return;
        }
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
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

    /**
     * 根据字符串构造BST
     * @param input
     * @return
     */
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }


    public static void main(String[] args) {
        System.out.println(3&(~3+1));
        System.out.println(4&(~4+1));
        System.out.println(5&(~5+1));
        int[] ints={3,9,20,15,7};
        TreeNodeUtils.buildTreeNodeUsingArray(ints);
    }
}
