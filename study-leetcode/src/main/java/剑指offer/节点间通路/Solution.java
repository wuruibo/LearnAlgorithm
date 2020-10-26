package 剑指offer.节点间通路;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
class Solution {
    private Map<Integer,List<int[]>> graphMap;
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        this.graphMap= Arrays.stream(graph).collect(Collectors.groupingBy(ints -> ints[0]));
        int[] visited=new int[n];
        visited[start]=1;
        dfs(visited,start);

        return visited[target]==0?false:true;
    }
    private void dfs(int[] visited,int current){
        List<int[]> nextNode=this.graphMap.get(current);
        if (nextNode==null || nextNode.size()==0) {
            return;
        }
        for (int i = 0; i < nextNode.size(); i++) {
            int next=nextNode.get(i)[1];
            if (visited[next]==0) {
                visited[next]=1;
                dfs(visited,next);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findWhetherExistsPath(3, new int[][]{{0, 1}, {0, 2}, {1, 2}, {1, 2}}, 0, 2));
        System.out.println(new Solution().findWhetherExistsPath(5, new int[][]{{0, 1}, {0, 2}, {0, 4}, {0, 4}, {0, 1}, {1, 3}, {1, 4}, {1, 3}, {2, 3}, {3, 4}}, 0, 4));
    }
}