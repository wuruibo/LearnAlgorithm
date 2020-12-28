package Contest.Contest44.Problem3;

import java.util.Arrays;

class Solution {
    public int[] findBall(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int[] res=new int[N];
        Arrays.fill(res,-1);
        for (int i = 0; i < N; ++i) {
            int m = 0, n = i;
            while (m < M) {
                if (grid[m][n] == 1) {
                    if (n + 1== N || grid[m][n + 1] == -1) {
                        break;
                    }
                    ++n;
                } else {
                    if (n == 0 || grid[m][n - 1] == 1) {
                        break;
                    }
                    --n;
                }
                ++m;
            }
            if (m == M) {
                res[i] = n;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Arrays.stream(new Solution().findBall(new int[][]{{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}})).forEach(a-> System.out.println(a));
    }
}