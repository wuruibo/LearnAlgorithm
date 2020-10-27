package BinarySearch.P644;

/**
 * Notes中答案误差不超过0.00001是使用二分搜索的提示，可以先确定最大平均值的范围一定在数组的最大元素和最小元素之间，然后在该区间内用二分搜索，
 * 对于每个值检查是否能找到满足平均值大于该值且长度不小于k的子数组，逐步缩小最大平均值的范围，直到误差小于0.00001。
 * 对于给定一个值m找出原数组是否含有满足平均值大于该值且长度不小于k的子数组的子问题，类似于滑动窗口，用sum[i]记录前i个元素之和减去i * m的值，
 * 这样sum[i] - sum[j]则为第j + 1个元素到第i个元素的和减去(i - j) * m，若大于零则表示这些元素平均值大于m，要维护i - j始终大于等于k，
 * 用min记录前sum[0]到sum[i - k]之间的最小值，遍历i，若存在sum[i] - min >= 0,则说明存在该子数组。
 *
 */
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double min = 10000;
        double max = -10000;
        for(int n: nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        double ans = min;
        while(max - min > 0.00001) {
            ans = (max + min) / 2;

            if(check(nums, k, ans)) {
                min = ans;
            } else {
                max = ans;
            }
        }
        return ans;
    }

    public boolean check(int[] nums, int k, double m) {
        double[] sum = new double[nums.length + 1];
        for(int i = 1; i < sum.length; ++i) {
            sum[i] = sum[i - 1] + nums[i - 1] - m;
        }
        double min = 0;
        for(int i = k; i < sum.length; ++i) {
            if(sum[i] - min >= 0) {
                return true;
            }
            min = Math.min(min, sum[i - k + 1]);
        }
        return false;
    }
}
