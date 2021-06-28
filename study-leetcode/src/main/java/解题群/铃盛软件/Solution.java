package 解题群.铃盛软件;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    private static LinkedHashMap<String,Integer> countMap;
    static {
        countMap=new LinkedHashMap<>();
        countMap.put("M", 1000);
        countMap.put("CM", 900);
        countMap.put("D", 500);
        countMap.put("CD", 400);
        countMap.put("C", 100);
        countMap.put("XC", 90);
        countMap.put("L", 50);
        countMap.put("XL", 40);
        countMap.put("X", 10);
        countMap.put("IX", 9);
        countMap.put("V", 5);
        countMap.put("IV", 4);
        countMap.put("I", 1);
    }
    public String intToRoman(int num) {
        StringBuilder result=new StringBuilder();
        Iterator<Map.Entry<String,Integer>> iterator=countMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String,Integer> entry=iterator.next();
            String key=entry.getKey();
            Integer value=entry.getValue();
            int count=num/value;
            num%=value;
            while (count!=0){
                result.append(key);
                count--;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        List<Integer> result= new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            result.add(i);
        }
        result=result.stream().filter((i)->i%2==0).collect(Collectors.toList());
        System.out.println(result);
        System.out.println(new Solution().intToRoman(3));
        System.out.println(new Solution().intToRoman(4));
        System.out.println(new Solution().intToRoman(9));
        System.out.println(new Solution().intToRoman(58));
        System.out.println(new Solution().intToRoman(1994));
    }
}