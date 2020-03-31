package TwoPointer.P532;

import java.util.Arrays;

/**
 * @autor yeqiaozhu.
 * @date 2020-03-31
 */
public class MoreClean {

    public  int findPairs(int[] nums, int k) {
        if(k<0 || nums.length<=1){
            return 0;
        }

        Arrays.sort(nums);
        int count = 0;
        int left = 0;
        int right = 1;

        while(right<nums.length){
            int firNum = nums[left];
            int secNum = nums[right];
            // If less than k, increase the right index
            if(secNum-firNum<k){
                right++;
            }
            // If larger than k, increase the left index
            else if(secNum - firNum>k){
                left++;
            }
            // If equal, move left and right to next different number
            else{
                count++;
                while(left<nums.length && nums[left]==firNum){
                    left++;
                }
                while(right<nums.length && nums[right]==secNum){
                    right++;
                }

            }
            //left and right should not be the same number
            if(right==left){
                right++;
            }
        }
        return count;
    }
}
