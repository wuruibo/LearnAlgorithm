package DepthFirstSearch.P332;

import java.util.*;

/**
 * 如果一张图中，从一个点出发可以走完所有的边，则这个遍历走过的路径就叫欧拉路径，可以理解成一张图可以一笔画出来。
 *
 * 已知图中存在欧拉路径，你要找出一个欧拉路径，可以用 hierholzer 算法。
 *
 * 1.任选一个点为起点（题目把起点告诉你了），遍历它所有邻接的边（设置不同的分支）。
 * 2.DFS 搜索，访问邻接的点，并且将走过的边（邻接关系）删除。
 * 3.如果走到的当前点，已经没有相邻边了，则将当前点推入 res。
 * 4.随着递归的出栈，点不断推入 res 的开头，最后就得到一个从起点出发的欧拉路径。
 * https://leetcode-cn.com/problems/reconstruct-itinerary/solution/shou-hua-tu-jie-liang-chong-jie-fa-zui-ji-ben-de-h/
 */
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // 因为逆序插入，所以用链表
        List<String> ans = new LinkedList<>();
        if (tickets == null || tickets.size() == 0) {
            return ans;
        }
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> pair : tickets) {
            // 因为涉及删除操作，我们用链表
            List<String> nbr = graph.computeIfAbsent(pair.get(0), k -> new LinkedList<>());
            nbr.add(pair.get(1));
        }
        // 按目的顶点排序
        graph.values().forEach(x -> x.sort(String::compareTo));
        visit(graph, "JFK", ans);
        return ans;
    }
    // DFS方式遍历图，当走到不能走为止，再将节点加入到答案
    private void visit(Map<String, List<String>> graph, String src, List<String> ans) {
        List<String> nbr = graph.get(src);
        while (nbr != null && nbr.size() > 0) {
            String dest = nbr.remove(0);
            visit(graph, dest, ans);
        }
        ans.add(0, src); // 逆序插入
    }

    public static void main(String[] args) {
        //new Solution().findItinerary(new int[])
    }
}