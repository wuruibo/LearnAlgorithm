package DynamicProgramming.P873;

/**
 * Example 1:
 *
 * Input: [1,2,3,4,5,6,7,8]
 * Output: 5
 * Explanation:
 * The longest subsequence that is fibonacci-like: [1,2,3,5,8].
 * Example 2:
 *
 * Input: [1,3,7,11,12,14,18]
 * Output: 3
 * Explanation:
 * The longest subsequence that is fibonacci-like:
 * [1,11,12], [3,11,14] or [7,11,18].
 */
class Solution {
    public int lenLongestFibSubseq(int[] A) {
        int[] dp=new int[A.length];
        int[] temp=new int[A.length];
        temp[0]=0;temp[1]=0;
        dp[0]=0;dp[1]=0;
        for (int i = 2; i < A.length; i++) {
            if (A[i]==(A[i-1]+A[i-2])) {
                int tempMax=temp[i-1]==0?3:temp[i-1]+1;
                temp[i]=tempMax;
                dp[i]=Math.max(tempMax,dp[i-1]);
            }else {
                temp[i]=0;
                dp[i]=dp[i-1];
            }
        }
        return dp[A.length-1];
    }

    public static void main(String[] args) {
        int[] ints={1,2,3,4,5,6,7,8};
        System.out.println(new Solution().lenLongestFibSubseq(ints));

        int[] ints1={1,3,7,11,12,14,18};
        System.out.println(new Solution().lenLongestFibSubseq(ints1));
    }
}