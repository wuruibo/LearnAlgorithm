package TwoPointer.MeDianTwoSortedArray;

import java.util.ArrayList;

/**
 * 寻找两个有序数组的中位数
 * <p>
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 */
public class MeDianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        ArrayList<Integer> arrayList = new ArrayList();
        int index1 = 0, index2 = 0;
        for (int i = 0; i < length; i++) {
            if (index1 > nums1.length - 1) {
                arrayList.add(nums2[index2]);
                index2++;
            } else if (index2 > nums2.length - 1) {
                arrayList.add(nums1[index1]);
                index1++;
            } else {
                if (nums1[index1] < nums2[index2]) {
                    arrayList.add(nums1[index1]);
                    index1++;
                } else {
                    arrayList.add(nums2[index2]);
                    index2++;
                }
            }
        }

        int mid = length / 2;
        if ((length & 1) == 0) {
            return (arrayList.get(mid) + arrayList.get(mid - 1)) / 2.0;
        } else {
            return arrayList.get(mid);
        }
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2};
        int[] array2 = {4, 5, 6};
        System.out.println(new MeDianOfTwoSortedArrays().findMedianSortedArrays(array1, array2));
    }
}
