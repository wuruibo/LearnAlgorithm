package 剑指offer.P59;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 同239题
 */
class Solution {
    /**
     * 暴力法
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums==null || nums.length==0) {
            return new int[]{};
        }
        int[] result=new int[nums.length-k+1];
        for (int i = 0; i <= nums.length-k; i++) {
            int tempMax=Integer.MIN_VALUE;
            for (int j = i; j < k+i; j++) {
                tempMax=Math.max(nums[j],tempMax);
            }
            result[i]=tempMax;
        }
        return result;
    }
    public int[] maxSlidingWindowDeque(int[] nums, int k){
        int[] result=new int[nums.length-k+1];
        //定义双端队列
        Deque<Integer> deque= new ArrayDeque<>();
        for (int i = 0,j=0; i <= nums.length - k; i++) {
            while (j - i <= k - 1) {
                //加入到队列中
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[j]) {
                    deque.pollLast();
                }
                deque.offerLast(j);
                j++;
            }
            //记录当前窗口最大值
            if (i>deque.peekFirst()) {
                deque.pollFirst();
            }
            result[i]=nums[deque.peekFirst()];
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.asList(new Solution().maxSlidingWindowDeque(new int[]{1,3,-1,-3,5,3,6,7}, 3)).toString());
        System.out.println(Arrays.asList(new Solution().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 1)).toString());
        System.out.println(Arrays.asList(new Solution().maxSlidingWindow(new int[]{}, 0)).toString());
    }
}