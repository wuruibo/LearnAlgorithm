package BinarySearch.P154;

/**
 * Example 1:
 *
 * Input: [1,3,5]
 * Output: 1
 * Example 2:
 *
 * Input: [2,2,2,0,1]
 * Output: 0
 *
 * 对比P153 本题元素可以重复 主要是如何处理重复 跟P81类似
 *
 * 1.mid有三种情况 如果nums[mid]<nums[end]那么最小值一定在mid的左边 可能包含mid --->end=mid
 *
 * 2.如果nums[mid]>nums[end]那么最小值一定在mid的右边 不包含mid ----> start=mid+1
 *
 * 3.如果nums[mid]==nums[end] 那么最小值不好说，可能在左边也可能在右边 所以不管是左边右边我们直接移动end的位置
 *
 * 相等的情况比较难处理，直接end--
 *
 */
class Solution {
    public int findMin(int[] nums) {
        int start=0,end=nums.length-1,mid;

        while (start<end){
            mid=(start+end)/2;

            if (nums[mid]<nums[end]) {
                end=mid;
            }else {
                if (nums[mid]>nums[end]) {
                    start=mid+1;
                }else {
                    end--;
                }
            }
        }
        return nums[start];
    }

    public static void main(String[] args) {
        int[] ints={2,2,2,0,1};
        System.out.println(new Solution().findMin(ints));

        int[] ints1={1,3,5};
        System.out.println(new Solution().findMin(ints1));

        int[] ints2={1,3,5,0,1,1,1,1,1,1,1,1};
        System.out.println(new Solution().findMin(ints2));
    }
}