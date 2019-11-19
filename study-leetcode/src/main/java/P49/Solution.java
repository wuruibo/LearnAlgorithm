package P49;

import java.util.*;

class Solution {
    private Map<String,List<String>> resultMap= new HashMap<>();
    public List<List<String>> groupAnagrams(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            char[] chars=strs[i].toCharArray();

            Arrays.sort(chars);
            String sortKey=new String(chars);
            //获取当前map中key为sort chars的数组
            List<String> strings=resultMap.getOrDefault(sortKey, new ArrayList<>());
            strings.add(strs[i]);
            resultMap.put(sortKey,strings);
        }

        //构建list出去
        List<List<String>> resultList=new ArrayList<>();

        for (List<String> value : resultMap.values()) {
            resultList.add(value);
        }

        return resultList;
    }

    public static void main(String[] args) {
        String[] strings={"eat", "tea", "tan", "ate", "nat", "bat"};
        new Solution().groupAnagrams(strings);
    }
}