package BFS.P103;

import CommonUtils.TreeNodeUtils;
import WaitingCollect.P104.TreeNode;

import java.util.*;

/**
 * 双端队列可以从前面插入也可以从后面插入
 * 双端队列可以从前面取出也可以从后面取出
 * 约等于是队列+栈
 * using deque
 * @autor yeqiaozhu.
 * @date 2019-11-23
 */
public class UsingDeque {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result= new ArrayList<>();
        if (root==null) {
            return result;
        }
        //通过双端队列来存储数据
        Deque<TreeNode> deque= new LinkedList<>();
        deque.offer(root);
        //定义当前级别为奇数还是偶数级别 true为奇数级别 false为偶数级别
        boolean flag=true;
        //开始循环
        while (!deque.isEmpty()) {
            int currentSize=deque.size();
            List<Integer> temp=new ArrayList<>();
            TreeNode tempNode;
            for (int i = 0; i < currentSize; i++) {
                if (flag) {
                    //如果当前是正常顺序的话 下一级别的枚举要倒序 并且当前枚举按照正常输出
                    tempNode=deque.pollFirst();

                    //倒加入双端队列
                    if (tempNode.left!=null) {
                        deque.offerLast(tempNode.left);
                    }
                    if (tempNode.right!=null) {
                        deque.offerLast(tempNode.right);
                    }
                }else {
                    tempNode=deque.pollLast();

                    //顺加入双端队列
                    if (tempNode.right!=null) {
                        deque.offerFirst(tempNode.right);
                    }
                    if (tempNode.left!=null) {
                        deque.offerFirst(tempNode.left);
                    }
                }
                temp.add(tempNode.val);
            }
            flag=!flag;
            result.add(temp);

        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode= TreeNodeUtils.stringToTreeNode("[3,9,20,null,null,15,7]");
        new UsingDeque().zigzagLevelOrder(treeNode);
    }
}
