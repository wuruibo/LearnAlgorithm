package BinarySearch.能力检测二分.P875;

class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        if(piles.length>H){
            return -1;
        }
        //1.找到最大的堆 二分的尾巴
        int right=0,left=1;
        for (int i = 0; i < piles.length; i++) {
            right=Math.max(right,piles[i]);
        }
        //2.开始二分操作 1～right范围内二分
        while(left<=right){
            int mid=left+((right-left)>>1);
            if(canEatingAll(piles,H,mid)){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    private boolean canEatingAll(int[] piles,int H,int speed){
        int count=0;
        for (int i = 0; i < piles.length; i++) {
            int n=piles[i]/speed;
            n+=piles[i]%speed==0?0:1;
            count+=n;
        }
        return count<=H;
    }
}