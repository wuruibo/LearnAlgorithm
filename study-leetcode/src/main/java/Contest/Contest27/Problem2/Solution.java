package Contest.Contest27.Problem2;

import java.util.Arrays;

class Solution {
    public int maxCoins(int[] piles) {
        int time=piles.length/3,result=0;
        Arrays.sort(piles);
        for (int i = 0,j=piles.length-2; i < time; i++) {
            result+=piles[j];
            j = j - 2;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxCoins(new int[]{2, 4, 1, 2, 7, 8}));
        System.out.println(new Solution().maxCoins(new int[]{2,4,5}));
        System.out.println(new Solution().maxCoins(new int[]{9,8,7,6,5,1,2,3,4}));
    }
}