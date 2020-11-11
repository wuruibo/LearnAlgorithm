package BinarySearch.P375;

class Solution {
    public int getMoneyAmount(int n) {
        int minCost=0,begin=1,end=n;
        while (begin!=end){
            int mid=begin+((end-begin)>>1);
            minCost+=mid;
            begin=mid+1;
        }
        return minCost;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getMoneyAmount(10));
    }
}