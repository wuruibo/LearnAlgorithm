package BinarySearch.P540;

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start=0,end=nums.length-1;
        while (start < end) {
            int mid=start+((end-start)>>1);
            //左边剩余的数如果为奇数 说明在左边 否则在右边
            if (nums[mid]==nums[mid-1]){
                if (((mid-start-1)&1)==0) {
                    start=mid+1;
                }else {
                    end=mid-2;
                }
            }else if (nums[mid]==nums[mid+1]){
                if (((end-mid-1)&1)==0) {
                    end=mid-1;
                }else {
                    start=mid+2;
                }
            }else {
                return nums[mid];
            }
        }
        return nums[start];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
        System.out.println(new Solution().singleNonDuplicate(new int[]{1}));
        System.out.println(new Solution().singleNonDuplicate(new int[]{1,1,2}));
        System.out.println(new Solution().singleNonDuplicate(new int[]{1,1,2,2,3}));
        System.out.println(new Solution().singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
        System.out.println(new Solution().singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
    }
}