package Contest.Contest13.Problem1;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>( Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (priorityQueue.size()<k+1) {
                    priorityQueue.offer(Math.abs(nums[i]-nums[j]));
                }else {
                    priorityQueue.poll();
                    priorityQueue.offer(Math.abs(nums[i]-nums[j]));
                }
            }
        }
        priorityQueue.poll();
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().smallestDistancePair(new int[]{2,2,0,1,1,0,0,1,2,0}, 2));
    }
}