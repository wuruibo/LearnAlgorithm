package BinarySearch.P985;

import java.util.Arrays;

/**
 * Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * Output: [8,6,2,4]
 * Explanation:
 * At the beginning, the array is [1,2,3,4].
 * After adding 1 to A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
 * After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
 * After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
 * After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.
 *
 * 按照逻辑直接写出来就行了 只不过避免重复计算偶数和 可以先判断当前改变的数是否为偶数（是偶数直接减掉） 并且判断改变后的数值是否为偶数（如果是直接加上）
 */
class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum=0;int[] result=new int[queries.length];
        //可以先计算一遍偶数和
        for (int i : A) {if ((i & 1)==0) {sum+=i;}}
        for (int i = 0; i < queries.length; i++) {
            //如果当前A索引位置是偶数 减去
            if ((A[queries[i][1]]&1)==0) {sum-=A[queries[i][1]];}
            //更新当前A索引位置的值 如果更新后为偶数 再加上
            A[queries[i][1]]+=queries[i][0];
            if ((A[queries[i][1]]&1)==0) {sum+=A[queries[i][1]];}

            //记录每一次附加运算的结果
            result[i]=sum;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A={1,2,3,4};
        int[][] queries={{1,0},{-3,1},{-4,0},{2,3}};
        Arrays.stream(new Solution().sumEvenAfterQueries(A, queries)).forEach(integer-> System.out.println(integer));
    }
}