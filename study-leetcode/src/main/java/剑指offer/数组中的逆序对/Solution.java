package 剑指offer.数组中的逆序对;

/**
 * 归并排序的方式做
 * [2,4,6,8]
 * [1,3,5,7]
 * 归并的过程中统计当添加右边的某个元素时 左边的数组大小累加
 */
class Solution {
    private int result=0;
    public int reversePairs(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return result;
    }
    private int[] mergeSort(int[] nums,int start,int end){
        if (start>=end) {
            return start>end?new int[]{}:new int[]{nums[start]};
        }
        int mid=start+((end-start)>>1);
        int[] left=mergeSort(nums,start,mid);
        int[] right=mergeSort(nums,mid+1,end);

        int l=0,r=0;
        int[] temp=new int[left.length+right.length];
        while (left.length > l || right.length > r) {
            if (left.length==l) {
                temp[l+r]=right[r++];
            }else if (right.length==r){
                temp[l+r]=left[l++];
            }else {
                if (right[r]<left[l]) {
                    temp[l+r]=right[r++];
                    result+=(left.length-l);
                }else {
                    temp[l+r]=left[l++];
                }
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reversePairs(new int[]{7,5,6,4}));
    }
}