package HashTable.P451;

import java.util.*;

/**
 * Example 1:
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 *
 * Input:
 * "cccaaa"
 *
 * Output:
 * "cccaaa"
 *
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 *
 * Input:
 * "Aabb"
 *
 * Output:
 * "bbAa"
 *
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 */
class Solution {
    public String frequencySort(String s) {

        Map<Character,Integer> result= countMap(s);
        //step2 放到treemap中根据次数排序 这里需要允许key重复
        Comparator<Integer> comparator=(integer1,integer2)-> integer1<=integer2?1:-1;

        Map<Integer,Character> temp=new TreeMap<>(comparator);
        Iterator<Map.Entry<Character,Integer>> iterator=result.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character,Integer> entry=iterator.next();
            temp.put(entry.getValue(),entry.getKey());
        }

        //step3 重新遍历出来
        StringBuilder stringBuilder=new StringBuilder();
        Iterator<Map.Entry<Integer,Character>> order=temp.entrySet().iterator();
        while (order.hasNext()) {
            Map.Entry<Integer,Character> entry=order.next();
            for (Integer integer = 0; integer < entry.getKey(); integer++) {
                stringBuilder.append(entry.getValue());
            }
        }

        return stringBuilder.toString();
    }
    public static Map<Character,Integer> countMap(String s){
        Map<Character,Integer> result= new HashMap<>();
        //step1 统计次数
        for (int i = 0; i < s.length(); i++) {
            Character key=s.charAt(i);
            result.put(key,result.getOrDefault(key,0)+1);
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().frequencySort("tree"));
        System.out.println(new Solution().frequencySort("a"));
        System.out.println(new Solution().frequencySort("cccaaa"));
        System.out.println(new Solution().frequencySort("Aabb"));
    }
}