package TwoPointer.P532;

import java.util.Arrays;

/**
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
 *
 * Example 1:
 * Input: [3, 1, 4, 1, 5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 * Example 2:
 * Input:[1, 2, 3, 4, 5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 * Example 3:
 * Input: [1, 3, 1, 5, 4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 * Note:
 * The pairs (i, j) and (j, i) count as the same pair.
 * The length of the array won't exceed 10,000.
 * All the integers in the given input belong to the range: [-1e7, 1e7].
 */
class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums==null || nums.length<=1) {
            return 0;
        }
        Arrays.sort(nums);
        int first=0,second=1,result=0;
        while (second<nums.length){
            int add=nums[second]-nums[first];
            if (add==k) {
                result++;
                int temp=nums[first];
                while (first<nums.length && temp == nums[first]){first++;}
                second=first+1;
            }else if(add>k && first<second-1) {
                first++;
            }else {
                second++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints={1, 2, 3, 4, 5};
        System.out.println(new Solution().findPairs(ints,1));

        int[] test={1, 3, 1, 5, 4};
        System.out.println(new Solution().findPairs(test,0));

        int[] test1={6,2,9,3,9,6,7,7,6,4};
        System.out.println(new Solution().findPairs(test1,3));
    }
}