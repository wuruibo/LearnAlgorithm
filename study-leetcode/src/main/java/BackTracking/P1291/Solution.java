package BackTracking.P1291;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1291. Sequential Digits
 * Medium
 *
 * 135
 *
 * 15
 *
 * Add to List
 *
 * Share
 * An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
 *
 * Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
 *
 *
 *
 * Example 1:
 *
 * Input: low = 100, high = 300
 * Output: [123,234]
 * Example 2:
 *
 * Input: low = 1000, high = 13000
 * Output: [1234,2345,3456,4567,5678,6789,12345]
 *
 *
 * Constraints:
 *
 * 10 <= low <= high <= 10^9
 */
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result= new ArrayList<>();
        backTracking(result,1,9,0,low,high);
        Collections.sort(result);
        return result;
    }
    private void backTracking(List<Integer> result,int begin,int end,int target,int low,int high){
        if (low<=target && high>=target) result.add(target);
        if (begin==10 || target>high) return;

        for (int i = begin; i <= end; i++) {
            target=target*10+i;
            backTracking(result,i+1,i+1,target,low,high);
            target=target/10;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sequentialDigits(1000, 13000).toArray()));
        System.out.println(Arrays.toString(new Solution().sequentialDigits(123, 234).toArray()));
        System.out.println(Arrays.toString(new Solution().sequentialDigits(10, 300).toArray()));
    }
}