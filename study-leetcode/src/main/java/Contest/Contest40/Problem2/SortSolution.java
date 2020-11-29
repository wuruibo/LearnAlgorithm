package Contest.Contest40.Problem2;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 找出最具竞争力的子序列
 * @author yeqiaozhu
 */
public class SortSolution {
    public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> deque= new LinkedList<>();
        int n=nums.length;
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] < deque.peekLast() && deque.size() + n - i-1 >= k) {
                deque.pollLast();
            }
            if (deque.size()<k) {
                deque.offerLast(nums[i]);
            }
        }
        //弹出
        int[] result=new int[k];
        int i=0;
        while (!deque.isEmpty()) {
            result[i++]=deque.pollFirst();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortSolution().mostCompetitive(new int[]{3, 5, 2, 6}, 2)));
        System.out.println(Arrays.toString(new SortSolution().mostCompetitive(new int[]{2, 4, 3, 3, 5, 4, 9, 6}, 4)));
    }
}
