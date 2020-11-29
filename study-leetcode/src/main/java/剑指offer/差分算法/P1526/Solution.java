package 剑指offer.差分算法.P1526;

/**
 * https://www.bilibili.com/video/BV1ri4y137Js?p=5
 * https://leetcode-cn.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/solution/java-lei-si-bo-feng-zhi-qiu-jie-by-bothin/
 */
class Solution {
    public int minNumberOperations(int[] target) {
        int n = target.length;
        int ans = target[0];
        for (int i = 1; i < n; ++i) {
            ans += Math.max(target[i] - target[i - 1], 0);
        }
        return ans;
    }
}
