package DynamicProgramming.P1186;

class Solution {
    public int maximumSum(int[] arr) {
        int len = arr.length;
        int[] f = new int[len];
        int[] g = new int[len];
        int res = arr[0]; 
        f[0] = arr[0];
        for(int i=1;i<len;i++){
            f[i] = Math.max(f[i-1]+arr[i],arr[i]);//其实就是f(i-1)是否<0
            g[i] = Math.max(g[i-1]+arr[i],f[i-1]);
            res = Math.max(res,Math.max(f[i],g[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumSum(new int[]{1, -2, 0, 3}));
        System.out.println(new Solution().maximumSum(new int[]{1,-2,-2,3}));
        System.out.println(new Solution().maximumSum(new int[]{-1,-1,-1,-1}));
    }
}
