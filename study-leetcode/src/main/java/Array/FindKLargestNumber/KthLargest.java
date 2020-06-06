package Array.FindKLargestNumber;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Method 1:采用优先级队列（最小堆）的方式实现，nlogk时间复杂度，k的空间复杂度
 * Method 2:采用排序的方式，nklogk时间复杂度，k的空间复杂度
 * @autor yeqiaozhu.
 * @date 2019-05-09
 */
public class KthLargest {

    private final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    private final int k;

    /**
     * 构建一个有k个元素的堆
     *
     * @param k
     * @param nums
     */
    public KthLargest(int k, int[] nums) {
        this.k = k;
        Arrays.stream(nums).forEach(integer ->
                add(integer));
    }

    public int add(int val) {
        //如果优先级队列中数量小于k，直接往最小堆中追加
        if (priorityQueue.size() < k) {
            priorityQueue.offer(val);
        } else if (priorityQueue.peek() < val) {//如果当前追加元素大于堆顶的元素，将堆顶的元素poll滚出，然后将当前的值offer进入堆
            priorityQueue.poll();
            priorityQueue.offer(val);
        }
        return priorityQueue.peek();
    }


    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, arr);
        System.out.println(kthLargest.add(3));   // returns 4
        System.out.println(kthLargest.add(5));   // returns 5
        System.out.println(kthLargest.add(10));  // returns 5
        System.out.println(kthLargest.add(9));   // returns 8
        System.out.println(kthLargest.add(4));   // returns 8
    }
}
