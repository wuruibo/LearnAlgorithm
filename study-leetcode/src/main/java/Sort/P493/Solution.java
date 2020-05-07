package Sort.P493;

/**
 * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
 *
 * You need to return the number of important reverse pairs in the given array.
 *
 * Example1:
 *
 * Input: [1,3,2,3,1]
 * Output: 2
 * Example2:
 *
 * Input: [2,4,3,5,1]
 * Output: 3
 * Note:
 * The length of the given array will not exceed 50,000.
 * All the numbers in the input array are in the range of 32-bit integer.
 */
class Solution {
    private int count=0;
    public int reversePairs(int[] nums) {
        mergeSort(0,nums.length-1,nums);
        return count;
    }
    private int[] mergeSort(int begin,int end,int[] nums){
        if (begin>end) return new int[0];
        if (begin==end) return new int[]{nums[begin]};

        int mid=begin+((end-begin)>>1);
        int[] left=mergeSort(begin,mid,nums);
        int[] right=mergeSort(mid+1,end,nums);
        //count pairs 数一下逆序对
        countPairs(left,right);
        return merge(left,right);
    }
    private int[] merge(int[] left,int[] right){
        int[] result=new int[left.length+right.length];
        int first=0,second=0,index=0;
        while (first<left.length || second<right.length){
            if (first==left.length) {
                result[index++]=right[second++];
            }else if (second==right.length){
                result[index++]=left[first++];
            }else {
                if (left[first]<right[second]) {
                    result[index++]=left[first++];
                }else {
                    result[index++]=right[second++];
                }
            }
        }
        return result;
    }
    private void countPairs(int[] left,int[] right){
        for (int i : left) count+=findIndexBinary(right,i);
    }
    private int findIndexBinary(int[] array,int target){
        int begin=0,end=array.length-1;

        while (begin<=end){
            int mid=begin+((end-begin)>>1);
            //防止溢出 溢出的情况特殊处理
            if ((long)2*array[mid]<target) {
                begin=mid+1;
            }else {
                end=mid-1;
            }
        }
        return begin;
    }

    public static void main(String[] args) {
        int[] test={1,3,2,3,1};
        System.out.println(new Solution().reversePairs(test));

        int[] array={2,4,3,5,1};
        System.out.println(new Solution().reversePairs(array));

        int[] array1={2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        System.out.println(new Solution().reversePairs(array1));

        int[] array2={2147483647,2147483647,-2147483647,-2147483647,-2147483647,2147483647};
        System.out.println(new Solution().reversePairs(array2));
    }
}