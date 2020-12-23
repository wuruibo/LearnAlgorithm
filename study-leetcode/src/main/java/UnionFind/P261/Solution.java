package UnionFind.P261;

class Solution {
    private int count;
    private int[] parents;
    public boolean validTree(int n, int[][] edges) {
        this.parents=new int[n];
        this.count=n;
        for (int i = 0; i < parents.length; i++) {
            parents[i]=i;
        }
        for (int i = 0; i < edges.length; i++) {
            if (!union(edges[i][0],edges[i][1])) {
                return false;
            }
        }
        return count==1?true:false;
    }
    private boolean union(int l,int r){
        int lp=find(l);
        int rp=find(r);
        if (lp==rp) {
            return false;
        }
        parents[lp]=rp;
        count--;
        return true;
    }
    private int find(int target){
        while (target != parents[target]) {
            target=parents[target];
        }
        return target;
    }
}