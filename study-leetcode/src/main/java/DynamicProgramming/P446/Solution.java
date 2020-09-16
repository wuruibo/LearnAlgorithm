package DynamicProgramming.P446;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Example:
 *
 * Input: [2, 4, 6, 8, 10]
 *
 * Output: 7
 *
 * Explanation:
 * All arithmetic subsequence slices are:
 * [2,4,6]
 * [4,6,8]
 * [6,8,10]
 * [2,4,6,8]
 * [4,6,8,10]
 * [2,4,6,8,10]
 * [2,6,10]
 *
 *
 * 问题分析
 * https://leetcode-cn.com/problems/arithmetic-slices-ii-subsequence/solution/java-dong-tai-gui-hua-by-rajunmz/
 *
 * 在P413的基础上做个变形
 *
 * 子问题：前i个数的等差数列组数
 *
 * 前驱性：第i+1个数的加入不会对前i个数的等差数列组成造成影响
 * 转移方程：如果用dp[i]表示以第i+1个数为最后一个元素的所有等差数列数，问题：怎么区分公差不同的等差数列
 * --改进：以dp[i][j]表示以A[i]-A[j]为公差
 * --得到：dp[i][j] = dp[j][k] + 1（A[i]-A[j] == A[j]-A[k]）
 * k怎么得到：遍历前n个数或者用HashMap预处理
 * --直接存储HashMap<A[i], i>的话，发现用例有重复 --> 用集合存储重复的A[i]
 * --还要考虑i、j、k的大小关系：i > j > k
 * 最后用例发现：加减之后，会出现大于int的数
 * --用long
 */
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        int ans = 0;
        int[][] dp = new int[n][n];
        Map<Long, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey((long) A[i])) {
                map.put((long) A[i], new ArrayList<>());
            }
            map.get((long) A[i]).add(i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long target = 2 * (long) A[j] - A[i];
                if (map.containsKey(target)) {
                    for (int k : map.get(target)) {
                        if (k < j) {
                            dp[i][j] += (dp[j][k] + 1);
                        }
                    }
                }
                ans += dp[i][j];
            }
        }
        return ans;
    }
}