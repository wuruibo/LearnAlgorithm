package DepthFirstSearch.P1245;

import java.util.*;

class Solution {
    private Map<Integer, List<Integer>> graph= new HashMap<>(32);
    private Integer end;
    private int max=0;
    public int treeDiameter(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            int[] current=edges[i];
            List<Integer> first=graph.getOrDefault(current[0], new ArrayList<>());
            first.add(current[1]);
            graph.put(current[0],first);
            
            List<Integer> second=graph.getOrDefault(current[1], new ArrayList<>());
            second.add(current[0]);
            graph.put(current[1],second);
        }
        Integer start=graph.keySet().stream().findFirst().get();
        dfs(start,new HashSet<>(),0);
        dfs(end,new HashSet<>(),0);
        return max;
    }
    private void dfs(Integer root, Set<Integer> visited,int depth){
        List<Integer> next=graph.get(root);
        if (!hasNext(next,visited)) {
            if (depth>max) {
                max=depth;
                end=root;
            }
            return;
        }
        visited.add(root);
        for (int i = 0; i < next.size(); i++) {
            if (!visited.contains(next.get(i))) {
                dfs(next.get(i),visited,depth+1);
            }
        }
        visited.remove(root);
    }
    private boolean hasNext(List<Integer> next,Set<Integer> visited){
        if (next==null || next.size()==0) {
            return true;
        }
        for (Integer integer : next) {
            if (!visited.contains(integer)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().treeDiameter(new int[][]{{0, 1}, {0, 2}}));
        System.out.println(new Solution().treeDiameter(new int[][]{{0,1},{1,2},{2,3},{1,4},{4,5}}));
        System.out.println(new Solution().treeDiameter(new int[][]{{0,1}}));
    }
}