package HashTable.P451;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * 每次从堆中拿到一个最大值 poll出一个最大值后堆会自动调整一个最大值上来
 * @autor yeqiaozhu.
 * @date 2020-01-16
 */
public class UsingPriorityQueue {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        IntStream.range(0, s.length()).forEach(i -> map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1));
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry e = pq.poll();
            IntStream.range(0, (int) e.getValue()).forEach(i -> sb.append(e.getKey()));
        }
        return sb.toString();
    }
}
