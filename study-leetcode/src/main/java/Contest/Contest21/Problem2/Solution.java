package Contest.Contest21.Problem2;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int kthFactor(int n, int k) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 1; i <= n; i++) {
            if (n%i==0) {
                if (priorityQueue.size() < k) {
                    priorityQueue.offer(i);
                } else if (priorityQueue.peek() > i) {
                    priorityQueue.poll();
                    priorityQueue.offer(i);
                }
            }
        }

        return priorityQueue.size()<k?-1:priorityQueue.peek();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().kthFactor(12, 3));
        System.out.println(new Solution().kthFactor(7, 2));
        System.out.println(new Solution().kthFactor(4, 4));
        System.out.println(new Solution().kthFactor(1, 1));
        System.out.println(new Solution().kthFactor(1000, 3));
    }
}