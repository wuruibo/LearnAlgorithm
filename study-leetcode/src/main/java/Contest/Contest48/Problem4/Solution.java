package Contest.Contest48.Problem4;

/**
 * https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs/solution/zhuang-ya-dp-jing-dian-tao-lu-xin-shou-j-3w7r/
 * todo 状态压缩练习
 */
class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        int n = jobs.length;
        int m = 1 << n;
        int[][] f = new int[k][m];
        int[] a = new int[m];
        for (int s = 0; s < m; s++) {
            for (int i = 0; i < n; i++) {
                if (((1 << i) & s) > 0) {
                    a[s] += jobs[i];
                }
            }
            f[0][s] = a[s];
        }
        for (int i = 1; i < k; i++) {
            for (int s = 0; s < m; s++) {
                f[i][s] = a[s];
                int ss = s;
                while (ss > 0) {
                    int tmp = f[i - 1][ss] > a[s - ss] ? f[i - 1][ss] : a[s - ss];
                    f[i][s] = f[i][s] < tmp ? f[i][s] : tmp;
                    ss = (ss - 1) & s;
                }
            }
        }
        return f[k - 1][m - 1];
    }
}