package DynamicProgramming.单串问题.最大子数组和.P918;

/**
 * 环形数组的最大子数组和
 * 1.求正常串儿的最大
 * 2.求正常串儿的最小 sum-最小
 */
class Solution {
    public int maxSubarraySumCircular(int[] A) {
        if (A==null || A.length==0) {
            return 0;
        }
        if (A.length==1) {
            return A[0];
        }
        //求正常串儿最大
        int max=A[0],last=A[0],sum=A[0];
        for (int i = 1; i < A.length; i++) {
            sum+=A[i];
            last=Math.max(last+A[i],A[i]);
            max=Math.max(max,last);
        }
        //找到正常串儿的最小
        int min=A[1],lastMin=A[1];
        for (int i = 2; i < A.length-1; i++) {
            lastMin=Math.min(lastMin+A[i],A[i]);
            min=Math.min(min,lastMin);
        }
        return Math.max(max,sum-min);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubarraySumCircular(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(new Solution().maxSubarraySumCircular(new int[]{1,-2,3,-2}));
        System.out.println(new Solution().maxSubarraySumCircular(new int[]{5,-3,5}));
        System.out.println(new Solution().maxSubarraySumCircular(new int[]{3,-1,2,-1}));
        System.out.println(new Solution().maxSubarraySumCircular(new int[]{3,-2,2,-3}));
        System.out.println(new Solution().maxSubarraySumCircular(new int[]{-2,-3,-1}));
        System.out.println(new Solution().maxSubarraySumCircular(new int[]{-2}));
    }
}