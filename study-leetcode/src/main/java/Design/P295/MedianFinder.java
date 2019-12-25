package Design.P295;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Example:
 *
 * Adding number 41
 * MaxHeap lo: [41]           // MaxHeap stores the largest value at the top (index 0)
 * MinHeap hi: []             // MinHeap stores the smallest value at the top (index 0)
 * Median is 41
 * =======================
 * Adding number 35
 * MaxHeap lo: [35]
 * MinHeap hi: [41]
 * Median is 38
 * =======================
 * Adding number 62
 * MaxHeap lo: [41, 35]
 * MinHeap hi: [62]
 * Median is 41
 * =======================
 * Adding number 4
 * MaxHeap lo: [35, 4]
 * MinHeap hi: [41, 62]
 * Median is 38
 * =======================
 * Adding number 97
 * MaxHeap lo: [41, 35, 4]
 * MinHeap hi: [62, 97]
 * Median is 41
 * =======================
 * Adding number 108
 * MaxHeap lo: [41, 35, 4]
 * MinHeap hi: [62, 97, 108]
 * Median is 51.5
 *
 *
 *
 *
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 */
class MedianFinder {

    /** initialize your data structure here. */
    /** 定义一个最大堆和一个最小堆*/
    Queue<Integer> minHeap= new PriorityQueue<>();
    //传入一个倒序的比较器
    Queue<Integer> maxHeap= new PriorityQueue<>(Collections.reverseOrder());
    public MedianFinder() {

    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (maxHeap.size()<minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        int minSize=minHeap.size();
        int maxSize=maxHeap.size();

        if (((maxSize+minSize)&1)==0) {
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }else {
            return maxHeap.peek()/1.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder=new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian()); //-> 1.5
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian()); //-> 2
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */