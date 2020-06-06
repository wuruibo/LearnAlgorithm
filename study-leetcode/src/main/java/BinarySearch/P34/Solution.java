package BinarySearch.P34;

import java.util.Arrays;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        //第一步 先查到其中一个目标位置
        int[] result={-1,-1};
        int targetIndex=binaryFind(nums,target);
        if (targetIndex==-1) {
            return result;
        }else {
            //往左边找到第一次出现目标值的地方
            result[0]=binaryFindLeft(nums,targetIndex,target);
            result[1]=binaryFindRight(nums,targetIndex,target);
        }
        return result;
    }

    public int binaryFind(int[] nums,int target){
        int start=0,end=nums.length-1;
        while (start<=end){
            //find mid
            int mid=(start+end)/2;
            if (nums[mid]==target) {
                return mid;
            }else if(nums[mid]<target){
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        return -1;
    }

    /**
     * 找到左边第一次出现目标值的位置
     * @param nums
     * @param targetIndex
     * @param target
     * @return
     */
    public int binaryFindLeft(int[] nums,int targetIndex,int target){
        int start=0,end=targetIndex;

        while (start!=end){
            int mid=(start+end)/2;

            if (nums[mid]<target) {
                start=mid+1;
            }else {
                end=mid;
            }
        }
        return start;
    }

    /**
     * 找到右边第一次大于目标值的位置
     * @param nums
     * @param targetIndex
     * @param target
     * @return
     */
    public int binaryFindRight(int[] nums,int targetIndex,int target){
        int start=targetIndex,end=nums.length-1;

        while (start!=end){
            int mid=(start+end)/2;

            if (nums[mid]>target) {
                end=mid;
            }else {
                start=mid+1;
            }
        }
        return nums[start]==target?start:start-1;
    }

    public static void main(String[] args) {
        int[] nums={5,7,7,8,8,10};
        Arrays.stream(new Solution().searchRange(nums, 8)).forEach(i-> System.out.print(i+" "));
        System.out.println();
        Arrays.stream(new Solution().searchRange(nums, 6)).forEach(i-> System.out.print(i+" "));
        System.out.println();
        int[] nums1={1};
        Arrays.stream(new Solution().searchRange(nums1, 1)).forEach(i-> System.out.print(i+" "));
    }
}