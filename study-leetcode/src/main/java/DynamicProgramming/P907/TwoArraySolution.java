package DynamicProgramming.P907;

import java.util.Deque;
import java.util.LinkedList;

/**
 * left[i]表达的是A[i]左边第一个比A[i]小的数的索引，如果都比A[i]大，那么为-1
 * right[i]表达的是A[i]右边第一个比A[i]小的数的索引，如果都比A[i]大，那么为n
 *
 *
 */
public class TwoArraySolution {
    public int sumSubarrayMins(int[] A) {
        int n=A.length;
        int[] left=new int[n];
        int[] right=new int[n];
        //通过stack找到每个位置左边第一个比它小的值的索引
        Deque<Integer> deque= new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && A[deque.peekLast()]>=A[i]){
                deque.pollLast();
            }
            left[i]=deque.isEmpty()?-1:deque.peekLast();
            deque.offerLast(i);
        }
        deque.clear();
        for (int i = n-1; i >= 0; i--) {
            while (!deque.isEmpty() && A[deque.peekLast()] >= A[i]) {
                deque.pollLast();
            }
            right[i]=deque.isEmpty()?n:deque.peekLast();
            deque.offerLast(i);
        }
        //循环计算每个位置
        // 计算结果
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += (i-left[i]) * (right[i]-i) * A[i];
            res %= 1000000007;
        }
        return (int)res;
    }

    public static void main(String[] args) {
        System.out.println(new TwoArraySolution().sumSubarrayMins(new int[]{71,55,82,55}));
    }
}
