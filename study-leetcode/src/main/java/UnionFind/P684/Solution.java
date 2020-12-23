package UnionFind.P684;

/**
 * 输入: [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 * 解释: 给定的无向图为:
 *   1
 *  / \
 * 2 - 3
 */
class Solution {
    private int[] parents;
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        //初始化数组并指向自己
        this.parents=new int[n+1];
        for (int i = 0; i < parents.length; i++) {
            parents[i]=i;
        }
        int[] result=null;
        for (int i = 0; i < edges.length; i++) {
            if (!union(edges[i][0],edges[i][1])) {
                result=edges[i];
            }
        }
        return result;
    }

    /**
     * 联通l和r两个节点
     * @param l
     * @param r
     */
    private boolean union(int l,int r){
        int lp=find(l);
        int rp=find(r);
        if (lp==rp) {
            return false;
        }
        parents[lp]=rp;
        return true;
    }
    /**
     * 找到l节点对应的父节点
     * @param l
     * @return
     */
    private int find(int l){
        while (parents[l] != l) {
            l=parents[l];
        }
        return l;
    }
}