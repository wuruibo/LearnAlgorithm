package Recursive.P435;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Example 1:
 *
 * Input: [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 * Example 2:
 *
 * Input: [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 * Example 3:
 *
 * Input: [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 */
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length==0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(arrays->arrays[0]));

        int count=0;
        int[] temp=intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0]<temp[1] && intervals[i][1]>=temp[1]) {
                count++;
            }else if(intervals[i][0]>=temp[1]){
                temp=intervals[i];
            }else {
                count++;
                temp=intervals[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] ints= {{2,6},{1,3},{8,10},{15,18}};
        int[][] ints1= {{1,4},{1,2},{1,3}};
        int[][] ints2= {{1,2},{2,3}};
        int[][] ints3= {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(new Solution().eraseOverlapIntervals(ints));
        System.out.println(new Solution().eraseOverlapIntervals(ints1));
        System.out.println(new Solution().eraseOverlapIntervals(ints2));
        System.out.println(new Solution().eraseOverlapIntervals(ints3));
    }
}