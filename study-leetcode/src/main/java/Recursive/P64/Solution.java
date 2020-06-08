package Recursive.P64;

class Solution {
    public int sumNums(int n) {
        return mergeSum(1,n);
    }
    private int mergeSum(int start,int end){
        if (start>end) return 0;
        if (start==end) return start;
        int mid=start+((end-start)>>1);

        return mergeSum(start,mid)+mergeSum(mid+1,end);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().sumNums(1));
        System.out.println(new Solution().sumNums(3));
        System.out.println(new Solution().sumNums(9));
    }
}