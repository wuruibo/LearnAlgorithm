package BinarySearch.P441;

/**
 * Example 1:
 *
 * n = 5
 *
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 *
 * Because the 3rd row is incomplete, we return 2.
 * Example 2:
 *
 * n = 8
 *
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 *
 * Because the 4th row is incomplete, we return 3.
 *
 */
class Solution {
    public int arrangeCoins(int n) {
        if (n==0) {
            return 0;
        }
        //step1 定义start和end
        long start=0,end= n;

        while (start<=end){
            long mid=(start+end)/2;
            //计算当前梯队的值
            long temp=(2+mid)*(mid+1)/2;
            if(temp>n){
                end=mid-1;
            }else {
                start=mid+1;
            }
        }
        return (int) start;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().arrangeCoins(8));
        System.out.println(new Solution().arrangeCoins(1804289383));
        System.out.println(new Solution().arrangeCoins(5));
        System.out.println(new Solution().arrangeCoins(1));
        System.out.println(new Solution().arrangeCoins(2));
        System.out.println(new Solution().arrangeCoins(4));
    }
}