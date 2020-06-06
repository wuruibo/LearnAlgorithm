package BinarySearch;

/**
 *  递归二分
 *  二分查找
 */
class Solution {
    private int[] nums;
    private int target;
    public int search(int[] nums, int target) {
        if (nums==null) {
            return -1;
        }
        this.nums=nums;
        this.target=target;
        return binarySearch(0,nums.length-1);
    }
    public int binarySearch(int start,int end){
        if (start==end) {
            return nums[start]==target?start:-1;
        }
        if (start>end){
           return -1;
        }
        int mid=(start+end)/2;

        if (nums[mid]==target) {
            return mid;
        }else {
            int left=binarySearch(start,mid-1);
            int right=binarySearch(mid+1,end);

            if (left!=-1) {
                return left;
            }else if (right!=-1){
                return right;
            }else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        int[] ints={-1,0,3,5,9,12};
        System.out.println(new Solution().search(ints,9));
        System.out.println(new Solution().search(ints,2));



    }
}