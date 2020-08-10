package Contest.Contest23.Problem3;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Comparator<int[]> comparator= (a,b)-> a[0]==b[0]?a[1]-b[1]:a[0]-b[0];
        PriorityQueue<int[]> priorityQueue=new PriorityQueue<>(comparator.reversed());

        //先统计一个二维数组出来
        for (int i = 0; i < mat.length; i++) {
            int[] temp=new int[2];
            temp[1]=i;
            for (int j = 0; j < mat[i].length; j++) {
                temp[0]+=mat[i][j];
            }
            //统计完之后往优先级队列添加
            if (priorityQueue.size()<k) {
                priorityQueue.offer(temp);
            }else {
                int[] top=priorityQueue.peek();
                int cha=temp[0]==top[0]?temp[1]-top[1]:temp[0]-top[0];
                if (cha<0){
                    priorityQueue.poll();
                    priorityQueue.offer(temp);
                }
            }
        }
        //收集优先级队列的元素
        int[] result=new int[priorityQueue.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i]=priorityQueue.poll()[1];
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(new Solution().kWeakestRows(new int[][]{{1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}}, 3));

        System.out.println(new Solution().kWeakestRows(new int[][]{{1,0,0,0},
                {1,1,1,1},
                {1,0,0,0},
                {1,0,0,0}}, 2));
    }
}