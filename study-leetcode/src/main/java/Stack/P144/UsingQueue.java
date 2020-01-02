package Stack.P144;

import CommonUtils.TreeNode;
import CommonUtils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 宽度优先搜索(不同于中序遍历 不要混淆)
 * @autor yeqiaozhu.
 * @date 2020-01-02
 */
@Deprecated
public class UsingQueue {
    public List<Integer> preorderTraversal(TreeNode root) {
        //step1 定义队列+遍历的结果list
        Queue<TreeNode> queue= new LinkedList<>();
        List<Integer> result= new ArrayList<>();
        //step2 添加初始化队列元素
        queue.offer(root);
        //step3 开始循环
        while (!queue.isEmpty()) {
            //step1 弹出一个元素
            TreeNode current=queue.poll();
            //step2 添加元素
            result.add(current.val);
            //step3 往队列继续添加元素
            if (current.left!=null) {queue.offer(current.left);}
            if (current.right!=null) {queue.offer(current.right);}
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode= TreeNodeUtils.stringToTreeNode("[1,null,2,3]");
        new UsingQueue().preorderTraversal(treeNode).stream().forEach(integer -> System.out.print(integer));
    }
}
