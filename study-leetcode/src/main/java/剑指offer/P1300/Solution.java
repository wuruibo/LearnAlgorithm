package 剑指offer.P1300;

import java.util.Arrays;

class Solution {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        //计算前缀和
        int[] subSum=new int[arr.length+1];
        for (int i = 1; i < arr.length; i++) {
            subSum[i]=subSum[i-1]+arr[i-1];
        }
        //循环求最小
        int min=Integer.MAX_VALUE;
        int tempClose=Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int temp=subSum[i+1]+arr[i]*(arr.length-i-1);
            int currentClose=Math.abs(temp-target);
            if (currentClose<tempClose) {
                min=arr[i];
                tempClose=Math.abs(temp-target);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findBestValue(new int[]{4, 9, 3}, 10));
        System.out.println(new Solution().findBestValue(new int[]{2,3,5}, 10));
        System.out.println(new Solution().findBestValue(new int[]{60864,25176,27249,21296,20204}, 56803));
    }
}