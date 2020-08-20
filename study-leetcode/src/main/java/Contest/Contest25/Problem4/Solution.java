package Contest.Contest25.Problem4;

import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int st = 0, ed = position[position.length - 1] - position[0];
        while (st < ed) {
            int mid = (st + ed) / 2 + (st + ed) % 2;
            if (posBall(position, mid) >= m) {
                st = mid;
            } else {
                ed = mid - 1;
            }
        }
        return ed;
    }

    private int posBall(int[] position, int dis) {
        int last = position[0], res = 1;
        for (int i = 0; i < position.length; ++i) {
            if (position[i] - last >= dis) {
                last = position[i];
                ++res;
            }
        }
        return res;
    }
}