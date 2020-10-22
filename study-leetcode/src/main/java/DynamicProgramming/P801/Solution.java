package DynamicProgramming.P801;

/**
 * 我们有两个长度相等且不为空的整型数组 A 和 B 。
 *
 * 我们可以交换 A[i] 和 B[i] 的元素。注意这两个元素在各自的序列中应该处于相同的位置。
 *
 * 在交换过一些元素之后，数组 A 和 B 都应该是严格递增的（数组严格递增的条件仅为A[0] < A[1] < A[2] < ... < A[A.length - 1]）。
 *
 * 给定数组 A 和 B ，请返回使得两个数组均保持严格递增状态的最小交换次数。假设给定的输入总是有效的。
 *
 * 示例:
 * 输入: A = [1,3,5,4], B = [1,2,3,7]
 * 输出: 1
 * 解释:
 * 交换 A[3] 和 B[3] 后，两个数组如下:
 * A = [1, 3, 5, 7] ， B = [1, 2, 3, 4]
 * 两个数组均为严格递增的。
 */
class Solution {
    public int minSwap(int[] A, int[] B) {
        int[][] dp=new int[A.length][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        for(int i=1; i<A.length; i++){
            //1. 已经各自有序
            //2. 存在交叉
            //3. 既有序，也交叉
            if(A[i-1]<A[i]&&B[i-1]<B[i]){// 各自有序
                if(A[i-1]<B[i] && B[i-1]<A[i]){// 且存在交叉
                    dp[i][0] = Math.min(dp[i-1][0],dp[i-1][1]);
                    dp[i][1] = Math.min(dp[i-1][0],dp[i-1][1])+1;
                }else{// 有序但不存在交叉
                    dp[i][0] = dp[i-1][0];//不交换，再上一轮不交换的基础上，不变。
                    dp[i][1] = dp[i-1][1]+1; // 由于不存在交叉，所以如果要交换的话，得在上一轮交换的基础上，本轮再次交换
                }
            }else{//无序，则必然存在交叉
                dp[i][0] = dp[i-1][1];// 由于必须交叉，所以如果要不换的话，必须在上一轮交换的基础上，本轮才可以不交换
                dp[i][1] = dp[i-1][0]+1;// 同上，必须在上一轮不交换的基础上，本轮交换
            }
        }
        return Math.min(dp[dp.length-1][0],dp[dp.length-1][1]);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minSwap(new int[]{1, 3, 5, 4}, new int[]{1, 2, 3, 7}));
    }
}