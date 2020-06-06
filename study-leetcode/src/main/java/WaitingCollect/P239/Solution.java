package WaitingCollect.P239;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums==null || nums.length==0) {
            return new int[0];
        }
        //构造结果集
        int[] result=new int[nums.length-k+1];
        //定义优先级队列
        Comparator<Integer> comparator=(integer1,integer2)->{
            if (integer1==integer2) {
                return 0;
            }
            return integer1<integer2?1:-1;
        };
        Queue<Integer> queue=new PriorityQueue<>(comparator);
        for (int i = 0; i < nums.length; i++) {
            if (i<k) {
                queue.add(nums[i]);
            }else {
                queue.remove(nums[i-k]);
                queue.add(nums[i]);
            }
            //优先级队列满的情况下取第一个
            if (queue.size()>=k) {
                result[i-k+1]=queue.peek();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={9,10,9,-7,-4,-8,2,-6};
        new Solution().maxSlidingWindow(nums,5);
    }
}