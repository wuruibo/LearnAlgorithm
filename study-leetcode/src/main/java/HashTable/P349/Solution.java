package HashTable.P349;

import java.util.Arrays;

/**
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);
        Arrays.sort(nums1);

        int second=0,first=0,index=0,length=nums2.length>nums1.length?nums1.length:nums2.length;
        int[] result=new int[length];
        while (first<nums1.length && second<nums2.length){
            if (nums1[first]==nums2[second]) {
                result[index]=nums1[first];
                index++;
                //直接跳到不等于当前值的位置
                int target=nums1[first];
                while (++first<nums1.length && nums1[first]==target);
                while (++second<nums2.length && nums2[second]==target);
            }else if(nums1[first]<nums2[second]){
                first++;
            }else {
                second++;
            }
        }
        //copy一下result
        return Arrays.copyOf(result,index);
    }

    public static void main(String[] args) {
        int[] first={2,2,1};
        int[] second={2,2};
        Arrays.stream(new Solution().intersection(first, second)).forEach(integer-> System.out.println(integer));

        int[] first1={4,9,5};
        int[] second1={9,4,9,8,4};
        Arrays.stream(new Solution().intersection(first1, second1)).forEach(integer-> System.out.println(integer));
    }
}