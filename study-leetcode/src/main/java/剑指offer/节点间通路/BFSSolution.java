package 剑指offer.节点间通路;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
 *
 * 示例1:
 *
 *  输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
 *  输出：true
 * 示例2:
 *
 *  输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
 *  输出 true
 * 提示：
 *
 * 节点数量n在[0, 1e5]范围内。
 * 节点编号大于等于 0 小于 n。
 * 图中可能存在自环和平行边。
 *
 *
 */
class BFSSolution {
    private Map<Integer,List<int[]>> graphMap;
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        this.graphMap= Arrays.stream(graph).collect(Collectors.groupingBy(ints -> ints[0]));
        int[] visited=new int[n];
        Queue<Integer> queue= new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                Integer current=queue.poll();
                visited[current]=1;

                List<int[]> nextNode=graphMap.getOrDefault(current,new ArrayList<>());
                for (int j = 0; j < nextNode.size(); j++) {
                    int next=nextNode.get(j)[1];
                    if (visited[next]==0) {
                        queue.offer(next);
                    }
                }
            }
        }

        return visited[target]==0?false:true;
    }


    public static void main(String[] args) {
        System.out.println(new BFSSolution().findWhetherExistsPath(3, new int[][]{{0, 1}, {0, 2}, {1, 2}, {1, 2}}, 0, 2));
        System.out.println(new BFSSolution().findWhetherExistsPath(5, new int[][]{{0, 1}, {0, 2}, {0, 4}, {0, 4}, {0, 1}, {1, 3}, {1, 4}, {1, 3}, {2, 3}, {3, 4}}, 0, 4));
    }
}
