package TopologicalSort.P210;

import java.util.*;

/**
 *
 *
 *
 * Input: 2, [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 *              course 0. So the correct course order is [0,1] .
 * Example 2:
 *
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
 *              courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 *              So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 *
 *
 *
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses<0){
            return new int[0];
        }
        //step1 标记每个节点的入度
        int[] inDegree=new int[numCourses];
        int[] result=new int[numCourses];
        Map<Integer, List<Integer>> startMap= new HashMap<>();
        Queue<Integer> queue= new LinkedList<>();

        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> temp=startMap.getOrDefault(prerequisites[i][1],new ArrayList<>());
            temp.add(prerequisites[i][0]);
            startMap.put(prerequisites[i][1],temp);
            inDegree[prerequisites[i][0]]++;
        }
        //step2 将第一个入度为0的节点加入到队列中
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i]==0) {
                queue.offer(i);
            }
        }
        int index=0;
        //step3 循环删除入度为0的节点
        while (!queue.isEmpty()){
            Integer current=queue.poll();
            result[index++]=current;
            //step 4 删除入度为0的节点的边==指向节点的入度减少1 （找到这个节点对应的关系 通过map存储可以减少一层循环）
            for (Integer integer : startMap.getOrDefault(current,new ArrayList<>())) {
                if (--inDegree[integer]==0) {
                    queue.offer(integer);
                }
            }
        }
        if (index==numCourses) {
            return result;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[][] ints={{1,0},{2,0},{3,1},{3,2}};
        Arrays.stream(new Solution().findOrder(4, ints)).forEach(integer-> System.out.print(integer+" "));
    }
}