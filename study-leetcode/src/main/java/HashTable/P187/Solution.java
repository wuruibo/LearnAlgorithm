package HashTable.P187;

import java.util.*;

/**
 *
 */
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result=new ArrayList<>();
        if (s==null || s.length()<10) {
            return result;
        }

        Map<String,Integer> resultMap= new HashMap<>();
        //定义循环几次
        for (int i = 0; i < s.length() - 9; i++) {
            String temp=s.substring(i,i+10);

            resultMap.put(temp,resultMap.getOrDefault(temp,0)+1);
        }

        //找出次数大于2的
        Set<Map.Entry<String,Integer>> set=resultMap.entrySet();
        Iterator<Map.Entry<String,Integer>> iterator=set.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String,Integer> entry=iterator.next();

            if (entry.getValue()>1) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        new Solution().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }
}