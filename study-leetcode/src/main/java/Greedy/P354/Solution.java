package Greedy.P354;

import java.util.Arrays;

/**
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 */
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        /**
         O(NlogN)的做法, 按照长度升序, 同长则宽度降序排列, 然后使用O(logN)
         的最长递增子序列解法(链接在评论中)来做即可. 排序后等于把在二维(长、宽)
         上的最长递增子序列问题转换成一维(宽)上的最长递增子序列的查找, 因为对于
         长度来说已经满足递增, 只需要在宽度上也递增即为递增序列, 同长时按宽度降
         序排列的原因是避免同长时宽度小的也被列入递增序列中, 例如[3,3], [3,4]
         如果宽度也按升序来排列, [3,3]和[3,4]会形成递增序列, 而实际上不行.
         **/
        int maxL = 0;
        int[] dp = new int[envelopes.length];
        Arrays.sort(envelopes, (a, b) -> (a[0] == b[0] ? b[1]-a[1] : a[0]-b[0]));

        for(int[] env : envelopes) {
            int lo = 0, hi = maxL;
            while(lo < hi) {
                int mid = lo+(hi-lo)/2;
                if(dp[mid] < env[1]) {
                    lo = mid+1;
                } else {
                    hi = mid;
                }
            }
            dp[lo] = env[1];
            if(lo == maxL) {
                maxL++;
            }
        }
        return maxL;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
    }
}