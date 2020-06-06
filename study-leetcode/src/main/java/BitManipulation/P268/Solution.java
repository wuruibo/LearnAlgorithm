package BitManipulation.P268;

/**
 * 利用总和
 */
class Solution {
    public int missingNumber(int[] nums) {
        int sum=0,expect=(nums.length+1)*nums.length/2;
        for (int num : nums) {
            sum+=num;
        }
        return expect-sum;
    }
}