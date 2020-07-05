package Contest.Contest7.Problem1;

import java.util.Arrays;

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr==null || arr.length==1) {
            return true;
        }
        Arrays.sort(arr);
        int distance=arr[1]-arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (distance!=(arr[i]-arr[i-1])) {
                return false;
            }
        }
        return true;
    }
}