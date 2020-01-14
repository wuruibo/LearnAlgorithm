
package Array.P442;

import java.util.ArrayList;
import java.util.List;

/**
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [2,3]
 */
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result= new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index=Math.abs(nums[i])-1;

            if (nums[index]<0) {
                result.add(Math.abs(nums[i]));
            }else {
                nums[index]=-nums[index];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints={10,2,5,10,9,1,1,4,3,7};
        new Solution().findDuplicates(ints).stream().forEach(integer -> System.out.print(integer+" "));

        int[] ints1s={1};
        new Solution().findDuplicates(ints1s).stream().forEach(integer -> System.out.print(integer+" "));
    }
}