package SlidingWindow.P1176;

class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        if(calories == null || calories.length == 0) {
            return 0;
        }
        int res = 0, sum = 0;
        for(int l = 0, r = 0; r < calories.length; r++) {
            sum += calories[r];
            if(r - l + 1 == k) {
                res += sum < lower ? -1 : 0;
                res += sum > upper ? 1 : 0;
                sum -= calories[l++];
            }
        }

        return res;
    }
}