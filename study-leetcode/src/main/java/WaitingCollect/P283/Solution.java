package WaitingCollect.P283;

/**
 * 双指针 时间复杂度O(M+N)
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int i=0,j=1;
        int mid;
        while (i<nums.length && j<nums.length){
            if (nums[i]==0) {
                if (nums[j]!=0) {
                    mid=nums[i];
                    nums[i]=nums[j];
                    nums[j]=mid;
                    i++;j++;
                }else {
                    j++;
                }
            }else {
                i++;j++;
            }
        }

    }

    public static void main(String[] args) {
        int[] ints={1,0};

        new Solution().moveZeroes(ints);
    }
}