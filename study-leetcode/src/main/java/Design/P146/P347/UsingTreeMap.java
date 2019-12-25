package Design.P146.P347;
import java.util.*;

/**
 * @autor yeqiaozhu.
 * @date 2019-10-11
 */
public class UsingTreeMap {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> countMap=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i],countMap.getOrDefault(nums[i],0)+1);
        }

        TreeMap<Integer,List<Integer>> treeMap= new TreeMap<>();
        for(int num : countMap.keySet()){
            int freq = countMap.get(num);
            if(!treeMap.containsKey(freq)){
                treeMap.put(freq, new LinkedList<>());
            }
            treeMap.get(freq).add(num);
        }

        List<Integer> res = new ArrayList<>();
        while(res.size()<k){
            Map.Entry<Integer, List<Integer>> entry = treeMap.pollLastEntry();
            res.addAll(entry.getValue());
        }

        return res;
    }

    public static void main(String[] args) {
        int[] ints={4,1,-1,2,-1,2,3};
        int[] ints1={1};
        new UsingTreeMap().topKFrequent(ints,2);
        new UsingTreeMap().topKFrequent(ints1,1);
    }
}
