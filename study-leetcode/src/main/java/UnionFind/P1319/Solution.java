package UnionFind.P1319;

class Solution {
    private int count;
    private int[] parents;
    public int makeConnected(int n, int[][] connections) {
        this.parents=new int[n];
        this.count=n;
        for (int i = 0; i < parents.length; i++) {
            parents[i]=i;
        }
        int remain=0;
        for (int i = 0; i < connections.length; i++) {
            if (!union(connections[i][0],connections[i][1])) {
                remain++;
            }
        }
        return count-remain<=1?count-1:-1;
    }
    private boolean union(int left,int right){
        int lp=find(left),rp=find(right);
        if (lp==rp) {
            return false;
        }
        parents[lp]=rp;
        count--;
        return true;
    }
    private int find(int target){
        while (parents[target] != target) {
            target=parents[target];
        }
        return target;
    }
}