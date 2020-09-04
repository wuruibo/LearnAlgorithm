package BFS.P582;

import java.util.*;

public class Solution {

    public List <Integer> killProcess(List <Integer> pid, List <Integer> ppid, int kill) {
        //构造父节点和直系儿子节点关系
        HashMap<Integer, List<Integer>> map = new HashMap<>(16);
        for (int i = 0; i < ppid.size(); i++) {
            if (ppid.get(i) > 0) {
                List<Integer> l = map.getOrDefault(ppid.get(i), new ArrayList <> ());
                l.add(pid.get(i));
                map.put(ppid.get(i), l);
            }
        }
        //bfs收集某一节点的儿子节点
        Queue<Integer> queue = new LinkedList< >();
        List<Integer> l = new ArrayList<>();
        queue.add(kill);
        while (!queue.isEmpty()) {
            int r = queue.remove();
            l.add(r);
            if (map.containsKey(r)) {
                for (int id: map.get(r)) {
                    queue.add(id);
                }
            }
        }
        return l;
    }
}

