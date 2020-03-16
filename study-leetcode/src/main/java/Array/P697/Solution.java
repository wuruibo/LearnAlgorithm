package Array.P697;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 *
 * 给定一个由非负整数数组组成的非空数组，该数组的度定义为其任何一个元素的最大频率。
 *
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 *
 * 您的任务是查找 nums (连续)子数组的尽可能小的长度，该子数组的度与 nums 相同。
 *
 * Example 1:
 * 例子一:
 *
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 * 例子二:
 *
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 */
class Solution {
    public int findShortestSubArray(int[] nums) {
            if (nums.length == 0 || nums == null) return 0;
            Map<Integer, int[]> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++){
               if (!map.containsKey(nums[i])){
                   map.put(nums[i], new int[]{1, i, i});  // the first element in array is degree, second is first index of this key, third is last index of this key
               } else {
                   int[] temp = map.get(nums[i]);
                   temp[0]++;
                   temp[2] = i;
               }
            }
            int degree = Integer.MIN_VALUE, res = Integer.MAX_VALUE;
            for (int[] value : map.values()){
                if (value[0] > degree){
                    degree = value[0];
                    res = value[2] - value[1] + 1;
                } else if (value[0] == degree){
                    res = Math.min( value[2] - value[1] + 1, res);
                }
            }
            return res;
        }
}