package Contest.Contest40.Problem1;

import java.util.Arrays;

class Solution {
    public int maximumWealth(int[][] accounts) {
        int max=0;
        for (int[] account : accounts) {
            max=Math.max(max,Arrays.stream(account).sum());
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumWealth(new int[][]{{1, 2, 3}, {3, 2, 1}}));
    }
}