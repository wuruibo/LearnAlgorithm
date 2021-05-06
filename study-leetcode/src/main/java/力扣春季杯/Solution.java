package 力扣春季杯;

import java.util.Arrays;

/**
 * 输入：nums = [2,5,3,5], target = 6
 *
 * 输出：1
 *
 * 解释：预算内仅能购买 nums[0] 与 nums[2]。
 *
 * 示例 2：
 *
 * 输入：nums = [2,2,1,9], target = 10
 *
 * 输出：4
 */
class Solution {
    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        int l=0,r=nums.length-1;
        int count=0;
        while (l<r){
            if (nums[l]+nums[r]<=target) {
                count+=r-l;
                count%=1000000007;
                l++;
            }else {
                r--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().purchasePlans(new int[]{2, 5, 3, 5}, 6));
        System.out.println(new Solution().purchasePlans(new int[]{2,2,1,9}, 10));
    }
}