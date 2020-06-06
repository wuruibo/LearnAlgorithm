package Contest.Contest4.Problem3;

import java.util.ArrayList;
import java.util.List;

/**
 * n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。
 *
 * 路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
 *
 * 今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
 *
 * 请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
 *
 * 题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
 * 输出：3
 * 解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
 * 示例 2：
 *
 *
 *
 * 输入：n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
 * 输出：2
 * 解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
 * 示例 3：
 *
 * 输入：n = 3, connections = [[1,0],[2,0]]
 * 输出：0
 *
 *
 * 提示：
 *
 * 2 <= n <= 5 * 10^4
 * connections.length == n-1
 * connections[i].length == 2
 * 0 <= connections[i][0], connections[i][1] <= n-1
 * connections[i][0] != connections[i][1]
 */
class Solution {
    public int minReorder(int n, int[][] connections) {
        //先构造有向图
        List<List<Integer>> graph= new ArrayList<>(n);
        List<List<Integer>> src=new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            src.add(new ArrayList<>());
        }
        for (int[] connection : connections) {
            Integer key=connection[0];
            Integer value=connection[1];
            List<Integer> dest=graph.get(key);
            dest.add(value);
            graph.set(key,dest);

            List<Integer> oDest=src.get(key);
            oDest.add(key);
            src.set(key,oDest);
        }
        //反向记录开始的位置

        for (int[] connection : connections) {
            Integer value=connection[0];
            Integer key=connection[1];
            List<Integer> dest=graph.get(key)==null?new ArrayList<>():graph.get(key);
            dest.add(value);
            src.set(key,dest);
        }

        //先通过dfs找到根节点
        List<Integer> leafs=new ArrayList<>();
        dfs(leafs,graph,0);

        //从根节点往0去走 看需要加多少根线
        int count=0;
        for (int i = 0; i < leafs.size(); i++) {
            Integer leaf=leafs.get(i);
            if (leaf==0) {
                break;
            }else if (graph.get(leaf).size()==0){
                List<Integer> dest=src.get(leaf);
                graph.set(leaf,dest);
                count++;
            }
        }

        return count;
    }
    private void  dfs(List<Integer> leafs,List<List<Integer>> graph,Integer root){
        if (graph.get(root).size()==0) {
            leafs.add(root);
            return;
        }
        for (int i = 0; i < graph.get(root).size(); i++) {
            dfs(leafs,graph,graph.get(root).get(i));
        }
    }

    public static void main(String[] args) {
        int[][] connections={{0,1},{1,3},{2,3},{4,0},{4,5}};
        System.out.println(new Solution().minReorder(6,connections));

        int[][] connections1={{1,0},{1,2},{3,2},{3,4}};
        System.out.println(new Solution().minReorder(5,connections1));

        int[][] connections2={{1,0},{2,0}};
        System.out.println(new Solution().minReorder(3,connections2));

    }
}