package 剑指offer.最小k个数;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

class Solution {
    public int[] smallestK(int[] arr, int k) {
        int[] result=new int[k];
        if (k==0) {
            return result;
        }
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            if (priorityQueue.size()<k) {
                priorityQueue.offer(arr[i]);
            }else if (priorityQueue.peek()>arr[i]){
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);
            }
        }
        //聚合
        int i=0;
        while (i<k){
            result[i++]=priorityQueue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.stream(new Solution().smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4)).boxed().collect(Collectors.toList()));
    }
}