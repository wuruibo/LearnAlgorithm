package BinarySearch.P81;

/**
 *
 */
class Solution {
    public boolean search(int[] nums, int target) {
        //二分查找
        int start=0,end=nums.length-1;

        while (start<end){
            int mid=(start+end)/2;
            //判断中间的位置是否符合
            if (nums[mid]==target) {
                return true;
            }
            //判断mid是在最小值左边还是右边 在最小值右边
            if (nums[mid]<nums[end]) {
                //当前位置如果在最小值右边
                if (target>nums[mid] && target<=nums[end]) {
                    start=mid+1;
                }else {
                    end=mid-1;
                }
            }else {//mid在最小值左边
                if (nums[mid]==nums[end]) {
                    end--;
                    continue;
                }
                //mid在最小值左边 同时目标值在mid--->end之间
                if (nums[mid]>target && target>nums[end]) {
                    end=mid-1;
                }else {
                    start=mid+1;
                }
            }

        }
        return (start==end && nums[start]==target)?true:false;
    }

    public static void main(String[] args) {
        int[] ints={3,1,1};
        System.out.println(new Solution().search(ints,3));

        System.out.println(new Solution().search(ints,3));
    }
}