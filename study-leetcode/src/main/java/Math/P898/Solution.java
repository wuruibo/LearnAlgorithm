package Math.P898;

import java.util.LinkedList;
import java.util.List;

/**
 * Example 1:
 *
 * Input: A = [1,2,0,0], K = 34
 * Output: [1,2,3,4]
 * Explanation: 1200 + 34 = 1234
 * Example 2:
 *
 * Input: A = [2,7,4], K = 181
 * Output: [4,5,5]
 * Explanation: 274 + 181 = 455
 * Example 3:
 *
 * Input: A = [2,1,5], K = 806
 * Output: [1,0,2,1]
 * Explanation: 215 + 806 = 1021
 * Example 4:
 *
 * Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * Output: [1,0,0,0,0,0,0,0,0,0,0]
 * Explanation: 9999999999 + 1 = 10000000000
 */
class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int index=A.length-1,jinwei=0;

        List<Integer> result= new LinkedList<>();
        while (index >= 0 || K>0) {
            //step1 找到对应位置数字
            int first=index<0?0:A[index];
            int second=K==0?0:K%10;
            //step2 计算和的余数+进位 余数直接保留下来 进位带到下一次计算
            int yushu=(first+second+jinwei)%10;
            jinwei=(first+second+jinwei)/10;
            //step3 进入到下一组计算
            K/=10;
            index--;

            result.add(0,yushu);
        }
        if (jinwei!=0) {result.add(0,jinwei);}

        return result;
    }

    public static void main(String[] args) {
        int[] A={1,2,0,0};
        int K=34;
        new Solution().addToArrayForm(A,K).stream().forEach(integer -> System.out.print(integer));
        System.out.println();

        int[] A1={2,7,4};
        int K1=181;
        new Solution().addToArrayForm(A1,K1).stream().forEach(integer -> System.out.print(integer));
        System.out.println();

        int[] A2={2,1,5};
        int K2=806;
        new Solution().addToArrayForm(A2,K2).stream().forEach(integer -> System.out.print(integer));
        System.out.println();

        int[] A3={9,9,9,9,9,9,9,9,9,9};
        int K3=1;
        new Solution().addToArrayForm(A3,K3).stream().forEach(integer -> System.out.print(integer));
        System.out.println();
    }
}