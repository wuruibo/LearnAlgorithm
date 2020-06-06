package HashTable.P350;

import java.util.Arrays;

/**
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 *
 *
 * @autor yeqiaozhu.
 * @date 2019-12-17
 */
public class UsingTwoPointer {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int first=0,second=0,index=0;
        int[] result=new int[nums1.length];
        while (first<nums1.length && second<nums2.length){
            if (nums1[first]==nums2[second]) {
                result[index]=nums1[first];
                index++;
                first++;
                second++;
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
        Arrays.stream(new UsingTwoPointer().intersect(first, second)).forEach(integer-> System.out.println(integer));

        int[] first1={4,9,5};
        int[] second1={9,4,9,8,4};
        Arrays.stream(new UsingTwoPointer().intersect(first1, second1)).forEach(integer-> System.out.println(integer));
    }
}
