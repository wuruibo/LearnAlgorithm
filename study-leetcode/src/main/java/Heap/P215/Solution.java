package Heap.P215;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    private PriorityQueue<Integer> priorityQueue;

    public int findKthLargest(int[] nums, int k) {
        priorityQueue = new PriorityQueue();
        Arrays.stream(nums).forEach(value -> {
            if (priorityQueue.size()<k) {
                priorityQueue.add(value);
            }else {
                if(value > priorityQueue.peek()){
                    priorityQueue.poll();
                    priorityQueue.offer(value);
                }
            }

        });
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        int[] ints = {3, 2, 1, 5, 6, 4};
        System.out.println(new Solution().findKthLargest(ints, 2));
    }
}