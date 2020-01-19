package Array.P643;

/**
 * Example 1:
 *
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 *
 *
 * Note:
 *
 * 1 <= k <= n <= 30,000.
 * Elements of the given array will be in the range [-10,000, 10,000].
 *
 */
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length<k){
            return 0;
        }
        //先计算第一个组
        int max=0;
        for (int i = 0; i < k; i++) {
            max+=nums[i];
        }
        int tempMax=max;
        for (int i = k; i < nums.length; i++) {
            tempMax+=(nums[i]-nums[i-k]);
            if (tempMax>max) {
                max=tempMax;
            }
        }

        return (double) max/k;
    }

    public static void main(String[] args) {
        int[] ints={1,12,-5,-6,50,3};
        System.out.println(new Solution().findMaxAverage(ints,4));
    }
}