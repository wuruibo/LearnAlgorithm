package Array.三火;

/**
 * 有一个整形数组，包含正数和负数，然后要求把数组内的所有负数移至正数的左边，且保证相对位置不变，
 * 要求时间复杂度为O(n), 空间复杂度为O(1)。例如，{10, -2, 5, 8, -4, 2, -3, 7, 12, -88, -23, 35}变化后是{-2, -4，-3, -88, -23,5, 8 ,10, 2, 7, 12, 35}。
 * @autor yeqiaozhu.
 * @date 2020-03-13
 */
public class Solution {
    public void exchange(int[] input){
        //定义double pointer
        int first=0,second=1;
        while (second<input.length){
            //第一种情况
        }
    }
    /**
     * 它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
     * 插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），
     * 因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
     * @param arr
     */
    public static void sort(Comparable[] arr) {
        int n = arr.length;

        // 写法一
//        for (int i = 1; i < n; i++) {
//            for (int j = i; j > 0; j--) {
//                // 如果 arr[j] < arr[j - 1], arr[j] 与 arr[j - 1] 交换位置
//                if (arr[j].compareTo(arr[j - 1]) < 0) {
//                    swap(arr, j, j - 1);
//                } else {
//                    break;
//                }
//            }
//        }

        // 写法二
//        for (int i = 1; i < n; i++) {
//            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
//                swap(arr, j, j - 1);
//            }
//        }

        // 写法三
        for (int i = 1; i < n; i++) {
            Comparable e = arr[i];
            int j;
            for (j = i; j > 0 && arr[j].compareTo(arr[j - 1]) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }
    /*public  void sort(int[] array){
        for (int i = 1; i < array.length; i++) {
            //第一步  根据二分获取到要插入的位置
            int index=findIndex(array,0,i,array[i]);
            //第二步 将插入的位置后面的部分移动下 并插入

        }
    }
    public int findIndex(int[] array,int from,int to,int value){
        //用二分的方式找到index位置
        int start=0,end=to;
        while (start<=end){
            int mid=start+(end-start)/2;

            if (value>= array[mid]) {
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        return start;
    }*/
}

