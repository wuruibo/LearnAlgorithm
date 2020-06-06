
package BinarySearch.P35;

/**
 * Binary Search
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int start=0,end=nums.length-1,mid;
        while (start <= end) {
            //找二分的中间位置2
            mid=(start+end)/2;
            if (nums[mid]==target) {
                return mid;
            }else {
                if (nums[mid]>target) {
                    end=mid-1;
                }else {
                    start=mid+1;
                }
            }
        }
        return start<end?end:start;
    }

    public static void main(String[] args) {
        int[] ints={1,3,5,6};
        int[] ints1={};

        System.out.println(new Solution().searchInsert(ints,5));
        System.out.println(new Solution().searchInsert(ints,3));
        System.out.println(new Solution().searchInsert(ints,7));
        System.out.println(new Solution().searchInsert(ints,0));

        System.out.println(new Solution().searchInsert(ints1,0));
    }
}