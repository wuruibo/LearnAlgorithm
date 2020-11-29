package 剑指offer.差分算法.P1904;

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] temp=new int[1001];
        for (int[] trip : trips) {
            int val=trip[0];
            int left=trip[1];
            int right=trip[2];

            temp[left]+=val;
            temp[right]-=val;
        }
        //计算前缀和
        for (int i = 0,tempSum=0; i < temp.length; i++) {
            tempSum+=temp[i];
            if (tempSum>capacity) {
                return false;
            }
        }
        return true;
    }
}