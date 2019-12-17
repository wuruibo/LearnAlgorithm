package BinarySearch.P153;


/**
 * Example 1:
 *
 * Input: [3,4,5,1,2]
 * Output: 1
 * Example 2:
 *
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 *
 *
 *
 *
 * 二分
 * 中间的值小于右边的值 说明最小值在左侧 end=mid（为什么不是mid-1因为该值可能是最小值）
 * 中间的值大于右边的值 说明最小值在右侧 start=mid+1;
 */
class Solution {
    public int findMin(int[] nums) {
        //定义二分首尾
        int start=0,end=nums.length-1,mid;
        while (start<end){
            mid=(start+end)/2;
            if (nums[mid]<nums[end]) {
                end=mid;
            }else {
                start=mid+1;
            }
        }
        return nums[start];
    }

    public static void main(String[] args) {
        int[] ints={3,4,5,1,2};
        System.out.println(new Solution().findMin(ints));

        int[] ints1={4,5,6,7,0,1,2};
        System.out.println(new Solution().findMin(ints1));
    }
}