package UnionFind.P685;

import java.util.Arrays;

class Solution {
    class UnionFind {
        int[] father;
        int[] sz; // 状态压缩
        int count ;
        UnionFind(int n) {
            this.father = new int[n];
            this.sz = new int[n];
            this.count = n;
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }

        public int find(int x) {
            if (x != father[x]) {
                father[x] = find(father[x]);
            }
            return father[x];
        }

        public boolean union(int x , int y) {
            x = find(x);
            y = find(y);
            if (x == y) {
                return false;
            }
            if (sz[x] < sz[y]) {
                int temp = x;
                x = y;
                y = temp;
            }
            father[y] = x;
            sz[x] += sz[y];
            --count;
            return true;
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int len = queries.length;
        Integer[] qid = new Integer[len];
        for (int i = 0; i < len; i++) {
            qid[i] = i;
        }
        Arrays.sort(qid,(a, b) -> a-b);
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        boolean[] res = new boolean[queries.length];

        UnionFind s = new UnionFind(n);
        // 记录边的情况
        int i = 0;
        for (int q : qid) {
            while (i < edgeList.length && edgeList[i][2] < queries[q][2]) {
                s.union(edgeList[i][0],edgeList[i][1]);
                i++;
            }
            if (s.find(queries[q][0]) == s.find(queries[q][1])) {
                res[q] = true;
            } else {
                res[q] = false;
            }
        }
        return  res;
    }
}