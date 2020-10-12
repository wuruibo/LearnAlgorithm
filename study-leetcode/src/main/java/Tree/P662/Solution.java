package Tree.P662;

import CommonUtils.TreeNode;

import java.util.LinkedList;

/**
 * @author yqz
 */
public class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> indexQueue = new LinkedList<>();
        queue.add(root);
        indexQueue.add(1);
        while (!queue.isEmpty()) {
            int left = indexQueue.peek();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode poll = queue.poll();
                Integer index = indexQueue.poll();
                res = Math.max(res, index - left + 1);
                if (poll.left != null) {
                    queue.add(poll.left);
                    indexQueue.add(index * 2);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                    indexQueue.add(index * 2 + 1);
                }
            }
        }
        return res;
    }
}
