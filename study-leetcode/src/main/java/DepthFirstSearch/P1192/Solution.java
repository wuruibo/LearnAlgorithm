package DepthFirstSearch.P1192;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (List<Integer> c : connections) {
            graph.computeIfAbsent(c.get(0), (k -> new ArrayList<Integer>())).add(c.get(1));
            graph.computeIfAbsent(c.get(1), (k -> new ArrayList<Integer>())).add(c.get(0));
        }
        int[] timestamps = new int[n];
        dfs(graph, 0, 0, 1, timestamps);
        return ans;
    }
    
    private int dfs(Map<Integer, List<Integer>> graph, int curr, int parent, int currTimestamp, int[] timestamps) {
        timestamps[curr] = currTimestamp;
        for (int nextNode : graph.getOrDefault(curr, new ArrayList<Integer>())) {
            if (nextNode == parent) {
                continue;
            }
            if (timestamps[nextNode] > 0) {
                timestamps[curr] = Math.min(timestamps[curr], timestamps[nextNode]);
            } else {
                timestamps[curr] = Math.min(timestamps[curr], dfs(graph, nextNode, curr, currTimestamp + 1, timestamps));
            }
            if (currTimestamp < timestamps[nextNode]) {
                ans.add(Arrays.asList(curr, nextNode));
            }
        }
        //System.out.println(Arrays.stream(timestamps).boxed().collect(Collectors.toList()).toString());
        return timestamps[curr];
    }

    public static void main(String[] args) {
        int[][] a={{0,1},{2,0},{1,2},{1,3}};
        List<List<Integer>> objects = new ArrayList<>();
        for (int[] aa: a) {
            objects.add(Arrays.stream(aa).boxed().collect(Collectors.toList()));
        }
        System.out.println(new Solution().criticalConnections(4, objects));
    }
}