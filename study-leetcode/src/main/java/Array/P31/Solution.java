package Array.P31;

import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] A) {
        if(A == null || A.length <= 1) return;
        int i = A.length - 2;
        while(i >= 0 && A[i] >= A[i + 1]) i--; // Find 1st id i that breaks descending order
        if(i >= 0) {                           // If not entirely descending
            int j = A.length - 1;              // Start from the end
            while(A[j] <= A[i]) j--;           // Find rightmost first larger id j
            swap(A, i, j);                     // Switch i and j
        }
        reverse(A, i + 1, A.length - 1);       // Reverse the descending sequence
    }

    public void reverse(int[] A, int i, int j) {
        while(i < j) swap(A, i++, j--);
    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    private void quickSort(int start,int end,int[] nums){
        if (start>=end) return;
        int privot=nums[start],mask=start;
        for (int i = start+1; i <= end; i++) {
            if (nums[i]<privot) {
                mask++;
                swap(nums,i,mask);
            }
        }
        swap(nums,start,mask);

        int mid=start+((end-start))>>1;
        quickSort(start,mid,nums);
        quickSort(mid+1,end,nums);
    }

    public static void main(String[] args) {
        int[] test={1,2,3};
        new Solution().nextPermutation(test);
        System.out.println(Arrays.toString(test));

        int[] nums={3,2,1};
        new Solution().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        int[] test1={1,1,5};
        new Solution().nextPermutation(test1);
        System.out.println(Arrays.toString(test1));

        int[] test2={1};
        new Solution().nextPermutation(test2);
        System.out.println(Arrays.toString(test2));

        int[] test3={};
        new Solution().nextPermutation(test3);
        System.out.println(Arrays.toString(test3));
    }
}