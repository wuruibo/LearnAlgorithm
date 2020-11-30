package 剑指offer.差分算法.P1109;

import java.util.Arrays;

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] temp=new int[n];
        for (int[] booking:bookings) {
            int left=booking[0];
            int right=booking[1];
            int val=booking[2];

            temp[left-1]+=val;
            if (right<n){
                temp[right]-=val;
            }
        }
        //求前缀和
        for (int i = 0,tempSum=0; i < n; i++) {
            tempSum+=temp[i];
            temp[i]=tempSum;
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5)));
        System.out.println(Arrays.toString(new Solution().corpFlightBookings(new int[][]{{3,3,5},{1,3,20},{1,2,15}}, 3)));
    }
}