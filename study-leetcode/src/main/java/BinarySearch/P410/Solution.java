package BinarySearch.P410;

import java.util.Arrays;

/**
 * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
 *
 * 注意:
 * 数组长度 n 满足以下条件:
 *
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * 示例:
 *
 * 输入:
 * nums = [7,2,5,10,8]
 * m = 2
 *
 * 输出:
 * 18
 *
 * 解释:
 * 一共有四种方法将nums分割为2个子数组。
 * 其中最好的方式是将其分为[7,2,5] 和 [10,8]，
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 *
 * 算法：二分+贪心
 */
class Solution {
    public int splitArray(int[] nums, int m) {
        //选择最小的和最大的进行二分 最小是m为数组长度 最大的是m为1
        int start= Arrays.stream(nums).max().getAsInt();
        int end= Arrays.stream(nums).sum();

        while (start<end){
            int mid=start+((end-start)>>1);
            if (greedySplit(mid,m,nums)) {
                start=mid+1;
            }else {
                end=mid;
            }
        }
        return end;
    }

    /**
     * 最少分割次数
     * @param target
     * @param nums
     * @return
     */
    private Boolean greedySplit(int target,int m,int[] nums){
        //开始贪心 最多不能超过target 尽可能多的拿数保证m的分割够用
        int currentSum=0,split=1;
        for (int i = 0; i < nums.length; i++) {
            if (currentSum+nums[i]>target) {
                split++;
                currentSum=nums[i];
            }else {
                currentSum+=nums[i];
            }
        }
        return m<split;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().splitArray(new int[]{7, 2, 5, 10, 8}, 2));
        System.out.println(new Solution().splitArray(new int[]{7, 2, 5, 10, 8}, 2));
    }
}