package DepthFirstSearch.P332;

import java.util.*;

/**
 * @author yeqiaozhu.
 * @date 5/8/21
 */
class NextSolution {
    public List<String> findItinerary(List<List<String>> tickets) {
        backTracking("",tickets,new boolean[tickets.size()],new ArrayList());
        return null;
    }
    private void backTracking(String from,List<List<String>> tickets,boolean[] visited,List<String> temp){
        if (temp.size()==tickets.size()+1) {

        }
        //筛选出下一次可以选择的tickets列表
        TreeMap<List<String>,Integer> next=new TreeMap<>(Comparator.comparing(a -> a.get(1)));
        for (int i = 0; i < tickets.size(); i++) {
            String tempFrom=tickets.get(i).get(0);
            if(!visited[i] && from.equals(tempFrom)){
                next.put(tickets.get(i),i);
            }
        }
        //往下继续回溯
        for (int i = 0; i < next.size(); i++) {
            Map.Entry<List<String>, Integer> entry = next.pollFirstEntry();
            List<String> key = entry.getKey();
            Integer value = entry.getValue();
            visited[value]=true;
            temp.add(key.get(0));
            backTracking(key.get(1),tickets,visited,temp);
            temp.remove(temp.size()-1);
            visited[value]=false;
        }
    }
}