package WaitingCollect.P581;

import java.util.Arrays;

/**
 * @autor yeqiaozhu.
 * @date 2019-10-15
 */
public class SortSolution {
    public int findUnsortedSubarray(int[] nums) {
        int[] copy=Arrays.copyOf(nums,nums.length);
        Arrays.sort(copy);
        int i=0,j=nums.length-1,shortest=0;
        while (i<j){
            if (nums[i]==copy[i]) {
                i++;
            }
            if (nums[j]==copy[j]) {
                j--;
            }
            if (nums[i]!=copy[i] && nums[j]!=copy[j]) {
                shortest=j-i+1;
                break;
            }
        }
        return shortest;
    }

    public static void main(String[] args) {
        int[] ints={1,2,3,4};
        new SortSolution().findUnsortedSubarray(ints);
    }
}
