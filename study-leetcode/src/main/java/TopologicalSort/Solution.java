package TopologicalSort;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Example 1:
 *
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 *
 * Example 3:
 *
 * Input: 3, [[1,0],[2,0],[3,1],[3,2]]
 * Output: true
 *
 *
 * 
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses<prerequisites.length){
            return false;
        }
        int[] inDegree=new int[numCourses];
        //step1 统计所有节点的入度
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue= new LinkedList<>();
        //step2 将第一个入度为零的节点加入到队列中
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i]==0) {
                queue.offer(i);
            }
        }
        //step3 开始循环删除入度为0的节点
        while (!queue.isEmpty()){
            Integer current=queue.poll();
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1]==current) {
                    if (--inDegree[prerequisite[0]]==0) {
                        queue.offer(prerequisite[0]);
                    }
                }
            }
        }
        //step4 判断所有节点的入度是否均为零
        for (int i : inDegree) {
            if (i!=0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][]  ints={{1,0},{2,0},{3,1},{3,2}};
        System.out.println(new Solution().canFinish(4,ints));
    }
}