package BinarySearch.P33;

class Solution {
    public int search(int[] nums, int target) {
        //二分查找
        int start=0,end=nums.length-1;

        while (start<end){
            int mid=(start+end)/2;
            //判断中间的位置是否符合
            if (nums[mid]==target) {
                return mid;
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
                //mid在最小值左边 同时目标值在mid--->end之间
                if (nums[mid]>target && target>nums[end]) {
                    end=mid-1;
                }else {
                    start=mid+1;
                }
            }

        }
        return (start==end && nums[start]==target)?start:-1;
    }

    public static void main(String[] args) {
        int[] ints={3,5,1};
        System.out.println(new Solution().search(ints,3));

        int[] ints1={4,5,6,7,0,1,2};
        System.out.println(new Solution().search(ints1,3));
    }
}