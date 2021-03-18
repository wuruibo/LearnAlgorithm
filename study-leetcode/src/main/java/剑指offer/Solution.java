package 剑指offer;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> priorityQueue=new PriorityQueue<>(
                Comparator.comparingDouble(anInt -> ((double) anInt[0]) / anInt[1] -((double)anInt[0] + 1) / (anInt[1] + 1))
        );
        for (int[] aClass : classes) {
            priorityQueue.offer(aClass);
        }
        while (extraStudents!=0){
            int[] top=priorityQueue.poll();
            top[0]++;
            top[1]++;
            priorityQueue.offer(top);
            extraStudents--;
        }
        double sum=0;
        for (int[] ints : priorityQueue) {
            sum+=((double) ints[0])/ints[1];
        }
        return sum/classes.length;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxAverageRatio(new int[][]{{1, 2}, {3, 5}, {2, 2}}, 2));
        System.out.println(new Solution().maxAverageRatio(new int[][]{{2,4},{3,9},{4,5},{2,10}}, 4));
    }
}