package TwoPointer.P27;

/**
 * 双指针问题线上前后遍历
 * while循环一次只动一个指针，满足条件后互换位置并且动两个指针
 *
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int start=0,end=nums.length-1,length=nums.length;

        while (start<=end){
            if (nums[end]==val) {
                end--;
                length--;
            }else if (nums[start]!=val) {
                start++;
            }else  {
                int temp=nums[start];
                nums[start]=nums[end];
                nums[end]=temp;
                start++;end--;length--;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] ints={0,1,2,2,3,0,4,2};
        System.out.println(new Solution().removeElement(ints,2));
        int[] int1s={4,5};
        System.out.println(new Solution().removeElement(int1s,5));
    }
}