
package BinarySearch.P162;

/**
 * 本题虽然是会出现多个peak number但是只需要定位其中一个即可
 *
 * 方法一：一遍扫描是可以的
 * 方法二：二分搜索到其中一个peak number就行
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 *
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 *              or index number 5 where the peak element is 6.
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int start=0,end=nums.length-1;
        while (start<=end){
            if (start==end && end==nums.length-1) {
                break;
            }
            int mid=start+(end-start)/2;

            if (nums[mid]<nums[mid+1]) {
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] ints={1,2,1};
        System.out.println(new Solution().findPeakElement(ints));


        int[] ints1={1,2,1,3,5,6,4};
        System.out.println(new Solution().findPeakElement(ints1));

        int[] ints2={1,2};
        System.out.println(new Solution().findPeakElement(ints2));
    }
}