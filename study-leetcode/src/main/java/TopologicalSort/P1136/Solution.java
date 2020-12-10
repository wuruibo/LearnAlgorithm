package TopologicalSort.P1136;

import java.util.*;

/**
 * 平行课程
 * 输入：N = 3, relations = [[1,3],[2,3]]
 * 输出：2
 * 解释：
 * 在第一个学期学习课程 1 和 2，在第二个学期学习课程 3。
 */
class Solution {
    public int minimumSemesters(int N, int[][] relations) {
        //1.构造图 key 节点值 value目的节点list
        Map<Integer, List<Integer>> graphs= new HashMap<>(16);
        //2.构造每个节点对应的入度的数组
        int[] inDegrees=new int[N];
        for (int i = 0; i < relations.length; i++) {
            int start=relations[i][0];
            List<Integer> ends=graphs.getOrDefault(start, new ArrayList<>());
            //维护终点列表 并在终点列表的索引位置入度+1
            ends.add(relations[i][1]);
            inDegrees[relations[i][1]-1]+=1;
            graphs.put(start,ends);
        }
        //3.开始bfs遍历 从入度为0的节点开始
        Queue<Integer> queue=new LinkedList<>();
        //4.先遍历一遍加入
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i]==0) {
                queue.offer(i+1);
            }
        }
        int result=0;
        while (!queue.isEmpty()) {
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                int current=queue.poll();
                for (Integer end : graphs.getOrDefault(current,new ArrayList<>())) {
                    inDegrees[end-1]--;
                    if (inDegrees[end-1]==0) {
                        queue.offer(end);
                    }
                }
            }
            result++;
        }
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i]!=0) {
                return -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumSemesters(3, new int[][]{{1, 3}, {2, 3}}));
    }
}