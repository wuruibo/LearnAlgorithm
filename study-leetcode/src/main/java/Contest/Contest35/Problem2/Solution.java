package Contest.Contest35.Problem2;

/**
 * n 座城市和一些连接这些城市的道路 roads 共同组成一个基础设施网络。每个 roads[i] = [ai, bi] 都表示在城市 ai 和 bi 之间有一条双向道路。
 *
 * 两座不同城市构成的 城市对 的 网络秩 定义为：与这两座城市 直接 相连的道路总数。如果存在一条道路直接连接这两座城市，则这条道路只计算 一次 。
 *
 * 整个基础设施网络的 最大网络秩 是所有不同城市对中的 最大网络秩 。
 *
 * 给你整数 n 和数组 roads，返回整个基础设施网络的 最大网络秩 。
 *
 * 输入：n = 4, roads = [[0,1],[0,3],[1,2],[1,3]]
 * 输出：4
 * 解释：城市 0 和 1 的网络秩是 4，因为共有 4 条道路与城市 0 或 1 相连。位于 0 和 1 之间的道路只计算一次。
 */
class Solution {

    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] map =new int[n][n];//邻接矩阵
        int[] degree =new int[n];//出度
        for (int[] road : roads) {
            map[road[0]][road[1]]++;
            map[road[1]][road[0]]++;
            degree[road[0]]++;
            degree[road[1]]++;
        }
        int ans =Integer.MIN_VALUE;
        for (int i = 0; i <n-1 ; i++) {
            for (int j = i+1; j <n ; j++) {
                int temp = degree[i]+degree[j]-map[i][j]; //出度和减去重复的边
                ans = Math.max(ans,temp);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximalNetworkRank(4, new int[][]{{0, 1}, {0, 3}, {1, 2}, {1, 3}}));
        System.out.println(new Solution().maximalNetworkRank(5, new int[][]{{0,1},{0,3},{1,2},{1,3},{2,3},{2,4}}));
        System.out.println(new Solution().maximalNetworkRank(8, new int[][]{{0,1},{1,2},{2,3},{2,4},{5,6},{5,7}}));
    }
}