package Heap.P973;

import sun.dc.pr.PRError;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 *
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 *
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 *
 *
 *
 * Example 1:
 *
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 *
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 *
 *
 * Note:
 *
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 */
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Comparator<int[]> comparator= Comparator.comparingInt(x -> (x[0] * x[0] + x[1] * x[1]));
        Queue<int[]> priorityQueue=new PriorityQueue<>(comparator.reversed());

        for (int[] point : points) {
            if (priorityQueue.size()>K) {
                priorityQueue.poll();
            }
            priorityQueue.offer(point);
        }
        int[][] result=new int[K][];
        if (K<points.length) priorityQueue.poll();
        for (int i = 0; i < K; i++) {
            result[i]=priorityQueue.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] closest1={{1,0},{0,1}};
        System.out.println(Arrays.asList(new Solution().kClosest(closest1, 2)).toString());

        int[][] closest={{1,3},{-2,2}};
        System.out.println(Arrays.asList(new Solution().kClosest(closest, 1)).toString());

        int[][] test1={{68,97},{34,-84},{60,100},{2,31},{-27,-38},{-73,-74},{-55,-39},{62,91},{62,92},{-57,-67}};
        System.out.println(Arrays.asList(new Solution().kClosest(test1, 5)).toString());

        int[][] test={{3,3},{5,-1},{-2,4}};
        System.out.println(Arrays.asList(new Solution().kClosest(test, 2)).toString());
    }
}