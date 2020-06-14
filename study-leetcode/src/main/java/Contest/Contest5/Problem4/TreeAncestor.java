package Contest.Contest5.Problem4;

class TreeAncestor {

    int [][] dp = new int [50010][20];//dp[i][j]表示 对于i节点来说,它的第2^j个祖先是某个节点
    //dp[i][j] = dp[dp[i][j - 1]][j - 1] 相当于 我要到第2 ^ j 个祖先，我先到2 ^ (j - 1)个祖先
    //再到祖先的2 ^ (j - 1)个祖先，举个例子，我要到dp[i][3] 先跳到dp[i][2] 再在dp[i][2]的基础上再
    //跳 2 ^ 2 ，一共跳了8步,和 2 ^ 3 次方一样

    public TreeAncestor(int n, int[] parent) {
        for(int i = 0 ;i < n ;i++){
            for(int j = 0 ;j < 20 ;j++){
                dp[i][j] = -1;
            }
        }

        for(int i = 0 ;i < parent.length ;i++){
            dp[i][0] = parent[i];
        }
        for(int i = 0 ; i < n ;i++){
            for(int j = 1 ;j < 20 ;j++){
                if(dp[i][j - 1] != -1)
                    dp[i][j] = dp[dp[i][j - 1]][j - 1];
            }
        }

    }

    public int getKthAncestor(int node, int k) {
        int j = 0;
        while(k > 0){
            if(k % 2 != 0){
                node = dp[node][j];
            }
            if(node == -1) return node;
            j++;
            k = k >> 1;
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
