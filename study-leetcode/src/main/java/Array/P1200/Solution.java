package Array.P1200;

import CommonUtils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.
 *
 * Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
 *
 * a, b are from arr
 * a < b
 * b - a equals to the minimum absolute difference of any two elements in arr
 *
 *
 * Example 1:
 *
 * Input: arr = [4,2,1,3]
 * Output: [[1,2],[2,3],[3,4]]
 * Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
 * Example 2:
 *
 * Input: arr = [1,3,6,10,15]
 * Output: [[1,3]]
 * Example 3:
 *
 * Input: arr = [3,8,-10,23,19,-4,-14,27]
 * Output: [[-14,-10],[19,23],[23,27]]
 *
 *
 * Constraints:
 *
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 */
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result=new ArrayList<>();

        if (arr==null || arr.length<2) {
            return result;
        }
        Arrays.sort(arr);
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            min=Math.min(arr[i+1]-arr[i],min);
        }
        for (int j = 0; j < arr.length-1; j++) {
            if (arr[j+1]-arr[j]==min) {
                List<Integer> param= new ArrayList<>();
                param.add(arr[j]);param.add(arr[j+1]);
                result.add(param);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] test={4,2,1,3};
        System.out.println(ArrayUtils.getInstance().printListArrayString(new Solution().minimumAbsDifference(test)));

        int[] test1={1,3,6,10,15};
        System.out.println(ArrayUtils.getInstance().printListArrayString(new Solution().minimumAbsDifference(test1)));

        int[] test2={3,8,-10,23,19,-4,-14,27};
        System.out.println(ArrayUtils.getInstance().printListArrayString(new Solution().minimumAbsDifference(test2)));

    }
}