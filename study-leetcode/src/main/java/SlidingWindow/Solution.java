package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Sliding window
 */
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack==null || needle==null) {
            return -1;
        }
        if (needle.length()==0) {
            return 0;
        }
        if (needle.length()>haystack.length()) {
            return -1;
        }
        //构造needle的map
        Map<Character,Integer> map= new HashMap<>();
        for (int i = 0; i < needle.length(); i++) {
            map.put(needle.charAt(i),map.getOrDefault(needle.charAt(i),0)+1);
        }
        //定义start和end sliding window
        int begin=0,end=0,counter=map.size();
        while (end<haystack.length()){
            Character curEnd=haystack.charAt(end);
            if (map.containsKey(curEnd)) {
                int newValue=map.get(curEnd)-1;
                map.put(curEnd,newValue);
                if (map.get(curEnd)==0) {
                    counter--;
                }
            }
            end++;
            //滑动begin
            while (counter==0){
                Character curBegin=haystack.charAt(begin);
                if (map.containsKey(curBegin)) {
                    Integer newValue=map.get(curBegin)+1;
                    map.put(curBegin,newValue);
                    if (map.get(curBegin)>0) {
                        counter++;
                    }
                }
                if (end-begin==needle.length()) {
                    String sub=haystack.substring(begin,end);
                    if (sub.equals(needle)) {
                        return begin;
                    }
                }
                begin++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
         //System.out.println(new Solution().strStr("mississippi","issip"));
         System.out.println(new Solution().strStr("mississippi","pi"));
    }
}