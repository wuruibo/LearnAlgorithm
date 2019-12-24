package Array.P41;

import java.util.Arrays;

/**
 * Example 1:
 *
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int index=1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==index) {
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] ints={0,2,2,1,1};
        int[] ints1={-1,0};
        int[] ints2={7,8,9,11,12};
        System.out.println(new Solution().firstMissingPositive(ints));
        System.out.println(new Solution().firstMissingPositive(ints1));
        System.out.println(new Solution().firstMissingPositive(ints2));
    }
}