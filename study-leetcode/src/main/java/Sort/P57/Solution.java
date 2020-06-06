package Sort.P57;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int[] toAdd = newInterval;

        for (int i = 0; i < intervals.length; i ++) {
            /*1. No overlap and toAdd appears before current interval, add toAdd to result.*/
            if (intervals[i][0] > toAdd[1]) {
                ans.add(toAdd);
                toAdd = intervals[i];
            }
            /*2. Has overlap, update the toAdd to the merged interval.*/
            else if (intervals[i][1] >= toAdd[0])
                toAdd = new int[] {Math.min(intervals[i][0], toAdd[0]),
                        Math.max(intervals[i][1], toAdd[1]) };
                /*3. No overlap and toAdd appears after current interval, add current interval to result.*/
            else ans.add(intervals[i]);
        }
        ans.add(toAdd);
        return ans.toArray(new int[ans.size()][2]);
    }
}