package MeDianTwoSortedArray;

import java.util.ArrayList;

/**
 * @autor yeqiaozhu.
 * @date 2019-05-13
 */
public class MeDianOfTwoSortedArraysNoTemp {

    //1.记录当前划分位置的前后节点
    private ArrayList<Integer> tempArray=new ArrayList<>();

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if(length1 >length2){
            findMedianSortedArrays(nums1,nums2);
        }
        int length = length1 + length2;
        if (length1 == 0 && length2 > 0) {
            return (nums2[length2 / 2] + nums2[(length2 - 1) / 2]) / 2.0;
        } else if (length2 == 0 && length1 > 0) {
            return (nums1[length1 / 2] + nums1[(length1 - 1) / 2]) / 2.0;
        } else {
            //2.若数组的长度为length1，那么分割数组的index位置为(length-1)/2,那么这里整个数组的分割位置为(length-1)/2,减去numsIndex1，但是因为数组是分成了两个，这里需要额外减去1
            int numIndex1 = (length1 - 1) / 2;
            int numIndex2 = (length - 1) / 2 - numIndex1 - 1;

            while (true) {
                //3.边界值，最左边==-1的边界值left设置为Integer.MIN_VALUE，最右边的边界值right==length-1设置为Integer.MAX_VALUE
                setLeftAndRight(numIndex1,nums1);
                setLeftAndRight(numIndex2,nums2);
                //4.比较更加直观
                Integer nums1Left=tempArray.get(0),nums1Right=tempArray.get(1),nums2Left=tempArray.get(2),nums2Right=tempArray.get(3);
                //5.满足截取的位置条件，数组一分割位置左边的元素小于数组二分割位置右边的元素，数组二分割位置左边的元素小于数组一分割位置右边的元素。
                if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                    //6.判断整个length的长度是否为偶数
                    int temp = length & 1;
                    if (temp == 1) {
                        return findMax(nums1Left, nums2Left) / 1.0;
                    } else {
                        return (findMax(nums1Left, nums2Left) + findMin(nums1Right, nums2Right)) / 2.0;
                    }
                } else if (nums1Left > nums2Right) {
                    numIndex1--;
                    numIndex2++;
                } else {
                    numIndex1++;
                    numIndex2--;
                }
                tempArray.clear();
            }
        }
    }
    private void setLeftAndRight(int index, int[] nums){
        int left,right;
        if (index == -1) {
            left = Integer.MIN_VALUE;
            right = nums[index + 1];
        } else if (index == nums.length- 1) {
            left = nums[index];
            right = Integer.MAX_VALUE;
        } else {
            left = nums[index];
            right = nums[index + 1];
        }
        tempArray.add(left);
        tempArray.add(right);
    }
    private int findMax(int a, int b) {
        return a > b ? a : b;
    }

    private int findMin(int a, int b) {
        return a > b ? b : a;
    }

    public static void main(String[] args) {

        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(new MeDianOfTwoSortedArraysNoTemp().findMedianSortedArrays(nums1, nums2));
    }
}

