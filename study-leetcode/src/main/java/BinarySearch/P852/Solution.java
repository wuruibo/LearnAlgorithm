package BinarySearch.P852;

/**
 *
 * Example 1:
 *
 * Input: [0,1,0]
 * Output: 1
 * Example 2:
 *
 * Input: [0,2,1,0]
 * Output: 1
 * Note:
 *
 * 3 <= A.length <= 10000
 * 0 <= A[i] <= 10^6
 * A is a mountain, as defined above.
 *
 */
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        if (A.length==0) {
            return 0;
        }
        int start=0,end=A.length-1;
        while (start<=end){
            int mid=start+(end-start)/2;

            if (A[mid+1]<A[mid]) {
                end=mid-1;
            }else {
                start=mid+1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] ints={0,1,0};
        System.out.println(new Solution().peakIndexInMountainArray(ints));


        int[] ints1={0,1,2,0};
        System.out.println(new Solution().peakIndexInMountainArray(ints1));
    }
}