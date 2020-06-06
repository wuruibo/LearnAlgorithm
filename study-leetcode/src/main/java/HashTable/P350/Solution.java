package HashTable.P350;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //step1 找到长度更长的数组
        int[] longer=nums1.length>nums2.length?nums1:nums2;
        int[] shorter=nums1.length<=nums2.length?nums1:nums2;

        //step2 将longer的数组加入hashmap
        Map<Integer,Integer> longerMap= new HashMap<>();
        for (int i : longer) {
            longerMap.put(i,longerMap.getOrDefault(i,0)+1);
        }
        //step3 遍历shorter数组
        int[] result=new int[shorter.length];
        int index=0;
        for (int i = 0; i < shorter.length; i++) {
            if (longerMap.containsKey(shorter[i]) && longerMap.get(shorter[i])>0) {
                longerMap.put(shorter[i],longerMap.get(shorter[i])-1);
                result[index]=shorter[i];
                index++;
            }
        }
        //step4 拷贝新数组
        int[] common=new int[index];
        for (int j = 0; j < common.length; j++) {
            common[j]=result[j];
        }
        return common;
    }

    public static void main(String[] args) {
        int[] first={1};
        int[] second={2,2};
        Arrays.stream(new Solution().intersect(first, second)).forEach(integer-> System.out.println(integer));

        int[] first1={4,9,5};
        int[] second1={9,4,9,8,4};
        Arrays.stream(new Solution().intersect(first1, second1)).forEach(integer-> System.out.println(integer));
    }
}