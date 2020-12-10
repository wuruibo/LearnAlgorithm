package Contest.Contest41.Problem2;

import java.util.Arrays;

class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0,r=nums.length-1,result=0;
        while (r > l) {
            int target=nums[r]+nums[l];
            if (target==k) {
                result++;
                l++;r--;
            }else if (target<k){
                l++;
            }else {
                r--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxOperations(new int[]{1, 2, 3, 4}, 5));
        System.out.println(new Solution().maxOperations(new int[]{3,1,3,4,3}, 6));
    }
}