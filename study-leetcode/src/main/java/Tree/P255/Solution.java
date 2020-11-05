package Tree.P255;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 验证前序遍历二叉树
 * 前序遍历先从根节点到左 找到最小的节点之后 后续加入的节点必须大于最小的节点 就能保证能够构造出任意如何条件的二叉搜索树
 *
 * 1.先序遍历，如果递减，一定是左子树；
 * 2.如果出现非递减的值，意味着到了某个节点的右子树；
 * 3.利用栈来寻找该节点，最后一个比当前元素小的从栈弹出的元素即为该节点的父亲节点，而且当前元素父节点即为新的下限值；
 * 4.后续的元素一定是比当前的下限值要大的，否则return false；
 *
 */
class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int i=0,min=Integer.MIN_VALUE;
        Deque<Integer> deque= new LinkedList<>();
        while (i<preorder.length){
            if (preorder[i]<min) {
                return false;
            }
            while (!deque.isEmpty() && preorder[i] > deque.peekLast()) {
                min=deque.pollLast();
            }
            deque.offerLast(preorder[i++]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().verifyPreorder(new int[]{5, 2, 1, 3, 6}));
    }
}