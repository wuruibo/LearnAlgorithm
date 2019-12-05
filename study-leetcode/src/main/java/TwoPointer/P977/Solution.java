package TwoPointer.P977;

/**
 * 关键是如何分割
 * 分割需要找到第一个负数 继续往左遍历
 * 分割需要找到第一个正数 继续往右遍历
 *
 *
 * Example 1:
 *
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Example 2:
 *
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 */
class Solution {
    public int[] sortedSquares(int[] A) {
        if (A.length==0) {
            return A;
        }
        //这种判断方式是不对的
        int left,right=0;
        //应该找到第一个负数和第一个正数
        while (right<A.length && A[right]<0){
            right++;
        }
        left=right-1;

        int[] result=new int[A.length];
        int index=0;
        while (left>=0 || right<A.length){
            if (left<0) {
                result[index]=A[right]*A[right];
                right++;
            }else if(right>=A.length){
                result[index]=A[left]*A[left];
                left--;
            }else {
                if (A[left]*A[left]<A[right]*A[right]) {
                    result[index]=A[left]*A[left];
                    left--;
                }else {
                    result[index]=A[right]*A[right];
                    right++;
                }
            }
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints={-4,-1,0,3,10};
        new Solution().sortedSquares(ints);

        int[] ints1={0,2};
        new Solution().sortedSquares(ints1);
    }
}