package BFS.P310;

import java.lang.reflect.Array;
import java.util.*;

/**
 * For an undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.
 *
 * Format
 * The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).
 *
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 *
 * Example 1 :
 *
 * Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 *
 *         0
 *         |
 *         1
 *        / \
 *       2   3
 *
 * Output: [1]
 * Example 2 :
 *
 * Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 *
 *      0  1  2
 *       \ | /
 *         3
 *         |
 *         4
 *         |
 *         5
 *
 * Output: [3, 4]
 * Note:
 *
 * According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
 * The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 */
class Solution {
    /*
     *剥洋葱解法：从外层向里层进行BFS遍历
     *具体思路：
     *将图转化为邻接表存储后，若只有一条边的则为最外围的元素，将外围元素全部加入队列
     *然后在队列弹出时，需要将这个结点在邻接表中删除，层层向里，最后只剩下2个元素以内时，则为最中心元素，即以它们作为树根会得到最小高度树
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n <= 0) return res;
        //this is needed...since when there is only 1 vertex... the indegree of it will be 0..this case is not included in the following discussion...
        if (n == 1) {
            res.add(0);
            return res;
        }
        List<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int[] indegree = new int[n];
        int cnt = n;
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            indegree[i] = graph[i].size();
            if (indegree[i] == 1) {
                leaves.add(i);
            }
        }
        while (cnt > 2) {
            int size = leaves.size();
            cnt -= size;
            for (int i = 0; i < size; i++) {
                int v = leaves.poll();
                for (int w : graph[v]) {
                    indegree[w]--;
                    if (indegree[w] == 1) {
                        leaves.add(w);
                    }
                }
            }
        }
        res.addAll(leaves);
        return res;
    }

    public static void main(String[] args) {
        int[][] test={{1, 0}, {1, 2}, {1, 3}};
        System.out.println(new Solution().findMinHeightTrees(4, test).toString());

        int[][] test1={{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        System.out.println(new Solution().findMinHeightTrees(6, test1).toString());



        int[][] test2={};
        System.out.println(new Solution().findMinHeightTrees(1, test2).toString());
    }
}