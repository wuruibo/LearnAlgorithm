package BinarySearch.P1341;

import java.util.*;

/**
 * Example 1:
 *
 * Input: mat =
 * [[1,1,0,0,0],
 *  [1,1,1,1,0],
 *  [1,0,0,0,0],
 *  [1,1,0,0,0],
 *  [1,1,1,1,1]],
 * k = 3
 * Output: [2,0,3]
 * Explanation:
 * The number of soldiers for each row is:
 * row 0 -> 2
 * row 1 -> 4
 * row 2 -> 1
 * row 3 -> 2
 * row 4 -> 5
 * Rows ordered from the weakest to the strongest are [2,0,3,1,4]
 * Example 2:
 *
 * Input: mat =
 * [[1,0,0,0],
 *  [1,1,1,1],
 *  [1,0,0,0],
 *  [1,0,0,0]],
 * k = 2
 * Output: [0,2]
 * Explanation:
 * The number of soldiers for each row is:
 * row 0 -> 1
 * row 1 -> 4
 * row 2 -> 1
 * row 3 -> 1
 * Rows ordered from the weakest to the strongest are [0,2,3,1]
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 2 <= n, m <= 100
 * 1 <= k <= m
 * matrix[i][j] is either 0 or 1.
 */
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        //step1 定义优先级队列 最大堆 comparator取反
        Comparator<Map.Entry<Integer,Integer>> comparator=(entry1,entry2)->entry1.getValue()!=entry2.getValue()?entry1.getValue()-entry2.getValue():entry1.getKey()-entry2.getKey();
        Queue<Map.Entry<Integer,Integer>> queue=new PriorityQueue<>(comparator.reversed());

        for (int i = 0; i < mat.length; i++) {
            int start=0,end=mat[i].length-1;
            while (start<=end){
                int mid=start+(end-start)/2;
                if (mat[i][mid]==1) {
                    start=mid+1;
                }else {
                    end=mid-1;
                }
            }
            Map.Entry<Integer,Integer> entry=new Node(i,start);
            //step2 放入数组中
            queue.offer(entry);
            if (queue.size()>k) {
                queue.poll();
            }
        }
        //step3 result
        int[] r=new int[k];
        for (int i = k-1; i >= 0; i--) {
            r[i]=queue.poll().getKey();
        }
        return r;
    }
    static  class Node implements Map.Entry<Integer,Integer>{
        private Integer key;
        private Integer value;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public Integer getKey() {
            return key;
        }

        @Override
        public Integer getValue() {
            return value;
        }

        @Override
        public Integer setValue(Integer value) {
            return this.value=value;
        }
    }

    public static void main(String[] args) {
        int[][] ints = {{1,0},{1,0},{1,0},{1,1}};
        int[][] result={{1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}};
        new Solution().kWeakestRows(ints,4);
        new Solution().kWeakestRows(result,2);
    }
}