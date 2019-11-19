package TwoPointer.P80;


/**
 * using two pointer
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int start=0,end;
        boolean flag=true;
        for (end = 1; end < nums.length; end++) {
            if (nums[start]==nums[end] && flag) {
                start++;
                nums[start]=nums[end];
                flag=false;
            }
            if (nums[start]!=nums[end]) {
                start++;
                nums[start]=nums[end];
                flag=true;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] ints={1,1,1,2,2,1,1,1,3,3,3};
        System.out.println(new Solution().removeDuplicates(ints));
    }
}