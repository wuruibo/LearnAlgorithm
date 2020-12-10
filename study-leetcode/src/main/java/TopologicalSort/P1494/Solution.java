package TopologicalSort.P1494;

import java.util.*;

class Solution {
    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        //1.构造入度表和图
        int[] inDegrees= new int[n];
        Map<Integer,List<Integer>> graph= new HashMap<>(16);
        for (int i = 0; i < dependencies.length; i++) {
            List<Integer> tos=graph.getOrDefault(dependencies[i][0],new ArrayList<>());
            tos.add(dependencies[i][1]);
            inDegrees[dependencies[i][1]-1]++;
            graph.put(dependencies[i][0],tos);
        }
        //2.预装载入度为0的节点
        Queue<Integer> queue=new ArrayDeque<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i]==0) {
                queue.offer(i+1);
            }
        }
        //3.开始bfs
        int result=0;
        while (!queue.isEmpty()) {
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                int current=queue.poll();
                List<Integer> next=graph.getOrDefault(current, new ArrayList<>());
                for (Integer to : next) {
                    inDegrees[to-1]--;
                    if (inDegrees[to-1]==0) {
                        queue.offer(to);
                    }
                }
            }
            result+=(size%k==0?size/k:size/k+1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minNumberOfSemesters(4, new int[][]{{2, 1}, {3, 1}, {1, 4}}, 2));
        System.out.println(new Solution().minNumberOfSemesters(5, new int[][]{{2,1},{3,1},{4,1},{1,5}}, 2));
        System.out.println(new Solution().minNumberOfSemesters(11, new int[][]{}, 2));
    }
}