package Greedy.P452;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Example:
 *
 * Input:
 * [[10,16], [2,8], [1,6], [7,12]]
 *
 * Output:
 * 2
 *
 * Explanation:
 * One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).
 */
class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length==0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(arrays->arrays[1]));

        int count=1;
        int[] temp=points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0]<=temp[1]) {
                continue;
            }
            count++;
            temp=points[i];
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] ints={{10,16}, {2,8}, {1,6}, {7,12}};
        System.out.println(new Solution().findMinArrowShots(ints));
    }
}