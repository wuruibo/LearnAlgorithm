package BFS.P1436;


import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String,List<List<String>>> graphMap=paths.stream().collect(Collectors.groupingBy(list->list.get(0)));
        Queue<String> queue= new LinkedList<>();
        queue.offer(paths.get(0).get(0));

        while (!queue.isEmpty()) {
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                String current=queue.poll();
                List<List<String>> nextNodes=graphMap.get(current);
                if (nextNodes==null || nextNodes.size()==0) {
                    return current;
                }
                for (int j = 0; j < nextNodes.size(); j++) {
                    queue.offer(nextNodes.get(j).get(1));
                }
            }
        }
        return "";

    }

    public static void main(String[] args) {
       // System.out.println(new Solution().destCity(new ArrayList<>())));
    }
}