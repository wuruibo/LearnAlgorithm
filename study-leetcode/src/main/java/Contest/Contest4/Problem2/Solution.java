package Contest.Contest4.Problem2;

import java.util.Arrays;

class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long max1= Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        long max2 = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
        for (int i = 1; i < horizontalCuts.length; i++) {
            max1 = Math.max(max1, horizontalCuts[i] - horizontalCuts[i - 1]);
        }

        for (int i = 1; i < verticalCuts.length; i++) {
            max2 = Math.max(max2, verticalCuts[i] - verticalCuts[i - 1]);
        }
        long a= (long)Math.pow(10,9)+7;
        return (int)((max1 * max2)%a);
    }

    public static void main(String[] args) {
        int h = 5, w = 4;int[] horizontalCuts ={1,2,4}, verticalCuts = {1,3};
        System.out.println(new Solution().maxArea(h, w, horizontalCuts, verticalCuts));

        int h1 = 5, w1 = 4;int[] horizontalCuts1 ={3,1}, verticalCuts1 = {1};
        System.out.println(new Solution().maxArea(h1, w1, horizontalCuts1, verticalCuts1));

        int h2 = 5, w2 = 4;int[] horizontalCuts2 ={3}, verticalCuts2 = {3};
        System.out.println(new Solution().maxArea(h2, w2, horizontalCuts2, verticalCuts2));
    }
}