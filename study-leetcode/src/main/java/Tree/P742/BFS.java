package Tree.P742;

import CommonUtils.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 将二叉树转为无方向图之后进行操作bfs
 * @author yeqiaozhu
 */
public class BFS {
    public int findClosestLeaf(TreeNode root, int k) {
        //把树转换为无向图
        int[][] graph = new int[1001][1001];
        //构建邻接表
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode now = queue.poll();

            TreeNode left = now.left, right = now.right;
            //如果找到k而且是叶子节点，那就return
            if (left == null && right == null) {
                if (now.val == k) {
                    return k;
                }
                for (int i = 0; i < 1001; i++) {
                    if (graph[i][now.val] == 1) {
                        graph[i][now.val] = 2;
                    }
                }
                continue;
            }
            if (left != null) {
                graph[now.val][left.val] = 1;
                graph[left.val][now.val] = 1;
                queue.offer(left);
            }
            if (right != null) {
                graph[now.val][right.val] = 1;
                graph[right.val][now.val] = 1;
                queue.offer(right);
            }
        }
        //bfs
        Queue<Integer> que = new LinkedList<>();
        Set<Integer> set = new HashSet();
        que.offer(k);
        while (!que.isEmpty()) {
            int now = que.poll();
            for (int i = 0; i < 1001; i++) {
                if (graph[now][i] == 2) {
                    return i;
                }
                if (graph[now][i] == 1 && set.add(i)) {
                    que.offer(i);
                }
            }
        }
        return -1;
    }
}
