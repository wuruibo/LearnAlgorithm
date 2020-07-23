package Stack.P1063;

class Solution {
    public int validSubarrays(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] >= nums[i]) {
                    result++;
                } else {
                    break;
                }
            }
        }
        return result;
    }
}