package UnionFind.P323;

/**
 * 给定编号从 0 到 n-1 的 n 个节点和一个无向边列表（每条边都是一对节点），请编写一个函数来计算无向图中连通分量的数目。
 *
 * 示例 1:
 *
 * 输入: n = 5 和 edges = [[0, 1], [1, 2], [3, 4]]
 *
 *      0          3
 *      |          |
 *      1 --- 2    4
 *
 * 输出: 2
 * 示例 2:
 *
 * 输入: n = 5 和 edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
 *
 *      0           4
 *      |           |
 *      1 --- 2 --- 3
 *
 * 输出:  1
 * 注意:
 * 你可以假设在 edges 中不会出现重复的边。而且由于所以的边都是无向边，[0, 1] 与 [1, 0]  相同，所以它们不会同时在 edges 中出现。
 */
class Solution {
    /**
     * 连通分量
     */
    private int count;
    /**
     * 数组存储
     */
    private int[] parents;

    public int countComponents(int n, int[][] edges) {
        this.count=n;
        this.parents=new int[n];
        //初始化parents指向自己
        for (int i = 0; i < parents.length; i++) {
            parents[i]=i;
        }
        //开始执行连通操作
        for (int i = 0; i < edges.length; i++) {
            union(edges[i][0],edges[i][1]);
        }
        return getCount();
    }

    /**
     * 连接图中两个节点
     * @param i
     * @param j
     */
    private void union(int i,int j){
        int rootLeft=find(i);
        int rootRight=find(j);
        if (rootLeft==rootRight) {
            return;
        }
        parents[rootLeft]=rootRight;
        count--;
    }
    private int find(int i){
        while (parents[i] != i) {
            i=parents[i];
        }
        return parents[i];
    }

    /**
     * 获取连通分量
     * @return
     */
    private int getCount(){
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countComponents(5, new int[][]{{0, 1}, {1, 2}, {3, 4}}));
        System.out.println(new Solution().countComponents(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}}));
        System.out.println(new Solution().countComponents(5, new int[][]{{0,1},{1,2},{0,2},{3,4}}));
    }
}