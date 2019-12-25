package SlidingWindow.P424;

import java.util.*;

class Solution {
    public int characterReplacement(String s, int k) {
        //定义滑动窗口左窗口和右窗口
        int begin=0,end=0;
        //定义一个hashmap用于存储滑动窗口中的key value统计值
        Map<Character,Integer> countMap=new HashMap<>();
        //定义返回的最大值
        int maxResult=0;
        //开始循环右窗口
        while (end<s.length()){
            countMap.put(s.charAt(end),countMap.getOrDefault(s.charAt(end),0)+1);
            end++;
            //如果当前的窗口已经超出了满足条件的返回 也就是maxCount+k>end-begin
            while ((end-begin)-getMax(countMap)>k){
                char begingChar=s.charAt(begin);
                countMap.put(begingChar,countMap.get(begingChar)-1);
                begin++;
            }
            maxResult=end-begin>maxResult?end-begin:maxResult;
        }
        return maxResult;
    }
    public int getMax(Map<Character,Integer> map){
        int max=0;
        for (Integer value : map.values()) {
            max=value>max?value:max;
        }
        return max;
    }
    public static void main(String[] args) {
        new Solution().characterReplacement("AABABBA",1);
    }
}