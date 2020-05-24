package DepthFirstSearch.P1443;

import java.util.*;

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer,List<Integer>> graph= new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            List<Integer> result=graph.getOrDefault(edges[i][0], new ArrayList<>());
            result.add(edges[i][1]);
            graph.put(edges[i][0],result);
        }

        return dfs(0,graph,hasApple)[0];
    }
    private int[] dfs(int root,Map<Integer,List<Integer>> graph,List<Boolean> hasApple){
        if (graph.get(root)==null || graph.get(root).size()==0) return hasApple.get(root)?new int[]{0,1}:new int[]{0,0};

        int[] count=hasApple.get(root)?new int[]{0,1}:new int[]{0,0};
        for (int i = 0; i < graph.get(root).size(); i++) {
            int[] sub=dfs(graph.get(root).get(i),graph,hasApple);
            if (sub[1]==1) {
                count[0]+=(sub[0]+2);
                count[1]=1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        List<Map> oldList=new ArrayList<>();
        Map oldMap=new HashMap<>();
        oldMap.put(1,2);
        oldList.add(oldMap);

/*        for (int i = 0; i < 2; i++) {
            for (Map map : oldList) {
                Map dst=new HashMap<>();
                ((ArrayList<Map>) oldList).clone();
                oldList.add(dst);
            }
        }*/
        List<Map> result=(List<Map>)((ArrayList<Map>) oldList).clone();
        oldList.addAll(result);
        System.out.println(oldList.toString());
        int[][] edges={{0,1},{1,2},{0,3}};
        Boolean[] hasApples={true,true,true,true};
        System.out.println(new Solution().minTime(0, edges, Arrays.asList(hasApples)));

        int[][] edges1={{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        Boolean[] hasApples1={false,false,true,false,false,true,false};
        System.out.println(new Solution().minTime(0, edges1, Arrays.asList(hasApples1)));

        Boolean[] hasApples2={false,false,true,false,true,true,false};
        System.out.println(new Solution().minTime(0, edges1, Arrays.asList(hasApples2)));

        Boolean[] hasApples3={false,false,false,false,false,false,false};
        System.out.println(new Solution().minTime(0, edges1, Arrays.asList(hasApples3)));
    }
}