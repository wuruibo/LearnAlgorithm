package Contest.Contest39.Problem4;

import java.util.Arrays;

class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> a[1] - a[0] - b[1] + b[0]);
        int min = 0;
        for (int[] task : tasks) {
            min = Math.max(min + task[0], task[1]);
        }
        return min;
    }
}