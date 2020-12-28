package DynamicProgramming.单串问题.子序列问题.P873;

import java.util.HashMap;
import java.util.Map;

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
    /**
     *  dp[i][j]: 以A[i],A[j] 结尾的最长的长度-2
     *  如果存在A[k]=A[j]-A[i] 且k<i 则 dp[i][j]=dp[k][i]+1
     * @param A
     * @return
     */
    public int lenLongestFibSubseq(int[] A) {
        int[][] dp = new int[A.length - 1][A.length];
        int maxLen=0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], i);
        }


        for (int i = 1; i < A.length - 1; i++) {
            for (int j = i+1; j < A.length; j++) {
                int stepLen = A[j] - A[i];//A[k]
                if (map.containsKey(stepLen) && map.get(stepLen) < i) {
                    int k=map.get(stepLen);
                    dp[i][j] =  dp[k][i] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]+2);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] ints={1,2,3,4,5,6,7,8};
        System.out.println(new Solution().lenLongestFibSubseq(ints));

        int[] ints1={1,3,7,11,12,14,18};
        System.out.println(new Solution().lenLongestFibSubseq(ints1));
    }
}