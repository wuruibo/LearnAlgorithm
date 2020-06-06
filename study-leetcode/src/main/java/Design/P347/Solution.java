
package Design.P347;

import java.util.*;

/**
 * 先用map再用优先级队列
 */
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> integerMap=new HashMap<>();
        //统计完出现的次数
        for (int i = 0; i < nums.length; i++) {
            if (integerMap.containsKey(nums[i])) {
                Integer value=integerMap.get(nums[i]);
                integerMap.put(nums[i],++value);
            }else {
                integerMap.put(nums[i],1);
            }
        }

        /*//定义一个比较器
        Comparator<Map.Entry<Integer,Integer>> comparator=
                (entry1,entry2)-> entry1.getValue()-entry2.getValue();
*/
        //定义一个比较器  这个操作可以类比上面的函数表达式
        Comparator<Map.Entry<Integer,Integer>> comparator=
                Comparator.comparing(Map.Entry<Integer,Integer>::getValue);


        //构造优先级队列
        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue=new PriorityQueue<>(
                k,comparator
        );
        //放入优先级队列
        integerMap.entrySet().forEach(integerIntegerEntry -> {
            if (priorityQueue.size()<k) {
                priorityQueue.offer(integerIntegerEntry);
            }else {
                Map.Entry<Integer,Integer> top=priorityQueue.peek();
                if (comparator.compare(integerIntegerEntry,top)>0) {
                    priorityQueue.poll();
                    priorityQueue.offer(integerIntegerEntry);
                }
            }
        });
        List<Integer> result=new ArrayList<>();
        //获取k大的key
        Iterator<Map.Entry<Integer,Integer>> iterator=priorityQueue.iterator();
        while (iterator.hasNext()) {
            result.add(iterator.next().getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints={4,1,-1,2,-1,2,3};
        new Solution().topKFrequent(ints,2);

        int[] ints1={1};
        new Solution().topKFrequent(ints1,1);
    }
}