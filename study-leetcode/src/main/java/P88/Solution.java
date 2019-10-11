
package P88;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0,j=0; i < m+n;) {
            if (i>m-1) {
                nums1[i]=nums2[j];
                i++;
            }else {
                if (nums1[i] <= nums2[j]) {
                    i++;
                } else {
                    //exchange nums[i]和nums[j]
                    int mid = nums1[i];
                    nums1[i] = nums2[j];
                    nums2[j] = mid;

                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        new Solution().merge(nums1,3,nums2,2);
    }
}