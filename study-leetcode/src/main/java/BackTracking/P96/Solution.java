package BackTracking.P96;

/**
 * 最直接能想到backtracking
 * 可以用递归消除重复子问题降低复杂度
 *
 */
class Solution {
    public int numTrees(int n) {
        return backTracking(1,n);
    }
    public int backTracking(int start,int end){
        if (start>=end) {
            return 1;
        }
        int tempSum=0;
        for (int i = start; i <= end; i++) {
            int left=backTracking(start,i-1);
            int right=backTracking(i+1,end);

            tempSum+=left*right;
        }
        return tempSum;
    }

    public static void main(String[] args) {
        new Solution().numTrees(3);
    }
}