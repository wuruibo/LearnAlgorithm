package 剑指offer.差分算法.P370;

import java.util.Arrays;

class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] temp=new int[length];
        for (int i = 0; i < updates.length; i++) {
            int left=updates[i][0];
            int right=updates[i][1];
            int val=updates[i][2];

            temp[left]+=val;
            if (right<length-1) {
                temp[right+1]-=val;
            }
        }
        //循环遍历结果
        for (int i = 1; i < temp.length; i++) {
            temp[i]+=temp[i-1];
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().getModifiedArray(5, new int[][]{{1, 3, 2}, {2, 4, 3}, {0, 2, -2}})));
    }
}