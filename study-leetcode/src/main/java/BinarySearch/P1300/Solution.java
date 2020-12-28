package BinarySearch.P1300;

import java.util.Arrays;

class Solution {
    public int findBestValue(int[] arr, int target) {
        int min=1,max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max=Math.max(max,arr[i]);
        }
        //在min和max之间进行二分
        int[] result=new int[2];
        while (max >= min) {
            int mid=min+((max-min)>>1);
            //计算将当前数组中所有元素都变为mid的时候的结果和
            int temp=Arrays.stream(arr).map(i->i>mid?mid:i).sum();
            if (Math.abs(temp-target)<Math.abs(result[1]-target)) {
                result=new int[]{mid,temp};
            }else if (Math.abs(temp-target)==Math.abs(result[1]-target) && mid<result[0]){
                result=new int[]{mid,temp};
            }
            //比较temp和target
            if (temp>=target) {
                max=mid-1;
            }else{
                min=mid+1;
            }
        }
        return result[0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findBestValue(new int[]{4, 9, 3}, 10));
        System.out.println(new Solution().findBestValue(new int[]{2,3,5}, 10));
        System.out.println(new Solution().findBestValue(new int[]{60864,25176,27249,21296,20204}, 56803));
    }
}