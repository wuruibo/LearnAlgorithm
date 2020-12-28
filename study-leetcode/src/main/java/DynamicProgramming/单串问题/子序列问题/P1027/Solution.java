package DynamicProgramming.单串问题.子序列问题.P1027;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长等差子序列
 * 可以类比最长feibonaci数列
 * todo:
 */
class Solution {
    public int longestArithSeqLength(int[] A) {
        int len = A.length;
        int[][] dp = new int[len][len];
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                dp[i][j] = 2;
            }
        }
        Map<Integer, Integer> map = new HashMap<>(16);
        int max = 0;
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                int target = 2 * A[i] - A[j];
                if(map.containsKey(target)) {
                    dp[i][j] = dp[map.get(target)][i] + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
            map.put(A[i], i);
        }
        return max;
    }

    public int longestArithSeqLengthNoSpace(int[] A) {
        if (A.length<2){
            return A.length;
        }
        int cha=A[1]-A[0];
        int preMax=2,max=2;

        for (int i = 2; i < A.length; i++) {
            if (A[i]-A[i-1]==cha) {
                preMax++;
                max=Math.max(preMax,max);
            }else {
                cha=A[i]-A[i-1];
                preMax=2;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestArithSeqLengthNoSpace(new int[]{3, 6, 9, 12}));
        System.out.println(new Solution().longestArithSeqLengthNoSpace(new int[]{9,4,7,2,10}));
        System.out.println(new Solution().longestArithSeqLengthNoSpace(new int[]{20,1,15,3,10,5,8}));

        System.out.println(new Solution().longestArithSeqLength(new int[]{3, 6, 9, 12}));
        System.out.println(new Solution().longestArithSeqLength(new int[]{9,4,7,2,10}));
        System.out.println(new Solution().longestArithSeqLength(new int[]{20,1,15,3,10,5,8}));
    }
}