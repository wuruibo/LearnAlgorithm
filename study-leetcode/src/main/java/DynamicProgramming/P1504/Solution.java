package DynamicProgramming.P1504;

class Solution {
    public int numSubmat(int[][] mat) {
        int n = mat.length, m = mat[0].length, ans = 0;
        for (int i = 0; i < n; i++) {

            // 统计
            for (int j = 0; j < n - i; j++) {
                int cur = 0;
                for (int k = 0; k < m; k++) {
                    if (mat[j][k] == 0) cur = 0;
                    else cur++;
                    ans += cur;
                }
            }

            // 压缩
            for (int j = 0; j < n - i - 1; j++) {
                for (int k = 0; k < m; k++) {
                    mat[j][k] &= mat[j+1][k];
                }
            }
        }
        return ans;
    }
}
