package DynamicProgramming.P978;

class Solution {
    public int maxTurbulenceSize(int[] A) {
        if (A.length <= 1) {
            return A.length;
        }

        int N = A.length;
        int[] f = new int[N+1];
        int[] g = new int[N+1];
        f[1] = 1;
        g[1] = 1;

        int res = 1;
        for (int k = 2; k <= N; k++) {
            if (A[k-1] > A[k-2]) {
                f[k] = g[k-1] + 1;
            } else {
                f[k] = 1;
            }
            if (A[k-1] < A[k-2]) {
                g[k] = f[k-1] + 1;
            } else {
                g[k] = 1;
            }
            res = Math.max(res, f[k]);
            res = Math.max(res, g[k]);
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9}));
        System.out.println(new Solution().maxTurbulenceSize(new int[]{4,8,12,16}));
        System.out.println(new Solution().maxTurbulenceSize(new int[]{100}));
    }
}