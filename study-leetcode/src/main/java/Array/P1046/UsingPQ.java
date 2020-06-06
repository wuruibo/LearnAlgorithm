package Array.P1046;

import java.util.PriorityQueue;

public class UsingPQ {
    public int lastStoneWeight(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> b - a);
        for (int a : A)
            pq.offer(a);
        while (pq.size() > 1)
            pq.offer(pq.poll() - pq.poll());
        return pq.poll();
    }

    public static void main(String[] args) {
        int[] ints={2,7,4,1,8,1};
        new UsingPQ().lastStoneWeight(ints);
    }
}
