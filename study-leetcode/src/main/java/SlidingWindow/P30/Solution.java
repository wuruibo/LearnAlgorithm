package SlidingWindow.P30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * sliding window template
 * 时间复杂度O(N)
 * 空间复杂度O(N)
 */
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        //定义存结果的list
        List<Integer> result=new ArrayList<>();
        if (s==null || s.length()==0 || words==null || words.length==0) {
            return result;
        }
        //定义位置 起点 终点 每次跳动的距离 定义一个counter标志
        int begin=0,end=0,step=words[0].length(),counter;
        //将word的列表存到map中
        Map<String,Integer> wordsMap=new HashMap<>();
        for (String word : words) {
            wordsMap.put(word,wordsMap.getOrDefault(word,0)+1);
        }
        //设置counter默认值
        counter=wordsMap.size();
        //sliding template 循环
        for (int i = 0; i < step; i++) {
            begin=i;end=i;
            while (end+step<=s.length()){
                String curString=s.substring(end,end+step);
                if (wordsMap.containsKey(curString)) {
                    wordsMap.put(curString,wordsMap.get(curString)-1);
                    if (wordsMap.get(curString)==0) {
                        counter--;
                    }
                }
                end+=step;
                while (counter==0){
                    String beginS=s.substring(begin,begin+step);
                    if (wordsMap.containsKey(beginS)) {
                        wordsMap.put(beginS,wordsMap.get(beginS)+1);
                        if (wordsMap.get(beginS)>0) {
                            counter++;
                        }
                    }
                    //满足条件的存下来
                    if (end-begin==step*words.length) {
                        result.add(begin);
                    }
                    begin+=step;
                }
            }
            wordsMap.clear();
            for (String word : words) {
                wordsMap.put(word,wordsMap.getOrDefault(word,0)+1);
            }
            counter=wordsMap.size();
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words={"ab","ba","ba"};
        String s="ababaab";
        new Solution().findSubstring(s,words);
    }
}