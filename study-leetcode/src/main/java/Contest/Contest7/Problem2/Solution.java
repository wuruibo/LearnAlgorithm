package Contest.Contest7.Problem2;

import java.util.Arrays;

/**
 * 先不要想着模拟，本题的意思是，根本没有什么对碰后反向，而是该走走。
 * 那么时间就是每个方向上最后一个走到边上的时间的最大值。
 */
class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        Arrays.sort(left);
        Arrays.sort(right);
        return Math.max(left.length>0?left[left.length-1]:0,right.length>0?n-right[0]:0);
    }
}