package Stack.P315;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 输入：nums = [5,2,6,1]
 * 输出：[2,1,1,0]
 * 解释：
 * 5 的右侧有 2 个更小的元素 (2 和 1)
 * 2 的右侧仅有 1 个更小的元素 (1)
 * 6 的右侧有 1 个更小的元素 (1)
 * 1 的右侧有 0 个更小的元素
 *
 */
class Solution {
    private int[] result;
    public List<Integer> countSmaller(int[] nums) {
        result=new int[nums.length];
        mergeSort(nums,0,nums.length-1);
        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }
    private int[] mergeSort(int[] nums,int start,int end){
        if (start>=end) {
            return start>end?new int[]{}:new int[]{start};
        }
        int mid=start+((end-start)/2);
        int[] left=mergeSort(nums,start,mid);
        int[] right=mergeSort(nums,mid+1,end);

        int l=0,r=0;
        int[] temp=new int[left.length+right.length];
        while (left.length > l || right.length > r) {
            if (left.length==l) {
                temp[l+r]=right[r++];
            }else if (right.length==r){
                result[left[l]]+=r;
                temp[l+r]=left[l++];
            }else {
                if (nums[right[r]]<nums[left[l]]) {
                    temp[l+r]=right[r++];
                }else {
                    result[left[l]]+=r;
                    temp[l+r]=left[l++];
                }
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countSmaller(new int[]{5,2,6,1}));
    }
}