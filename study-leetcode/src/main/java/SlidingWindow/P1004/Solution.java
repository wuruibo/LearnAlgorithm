package SlidingWindow.P1004;

/**
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 *
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *
 */
class Solution {
    public int longestOnes(int[] A, int K) {
        //转换为找最多包含k个0的最长子数组
        int max=0;
        for (int r = 0,l=0; r < A.length; r++) {
            if (A[r]==0) {
                K--;
            }
            while (K < 0) {
                if (A[l]==0) {
                    K++;
                }
                l++;
            }
            max=Math.max(max,r-l+1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(new Solution().longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
        System.out.println(new Solution().longestOnes(new int[]{0}, 0));
    }
}