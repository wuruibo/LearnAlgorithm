package Stack.P144;

import CommonUtils.TreeNode;
import CommonUtils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 采用栈保存右边的节点，栈先入后出，可以保证节点按照递归自底向上输出。
 *
 * @autor yeqiaozhu.
 * @date 2020-01-02
 */
public class UsingStack {
    public List<Integer> preorderTraversal(TreeNode root) {
        //step1 栈保存右节点
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> result= new ArrayList<>();
        if (root!=null) {
            stack.push(root);
        }
        //循环迭代
        while (!stack.isEmpty()){
            TreeNode current=stack.pop();
            result.add(current.val);
            //将先输出的节点放到栈顶 bread-first-search是直接按照从左到右的顺序（利用队列） 这里是利用stack特点将左子树遍历完（利用栈）
            if (current.right!=null) {
                stack.push(current.right);
            }
            if (current.left!=null) {
                stack.push(current.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode= TreeNodeUtils.stringToTreeNode("[]");
        new UsingStack().preorderTraversal(treeNode).stream().forEach(integer -> System.out.print(integer));

    }
}
