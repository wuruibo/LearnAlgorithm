package P76;

import java.util.HashMap;
import java.util.Map;

/**
 * sliding window
 */
class Solution {
    public String minWindow(String s, String t) {
        //定义sliding begin位置 end位置 结束标记counter计数器
        int begin=0,end=0,counter;
        Integer len=s.length();
        String target="";
        Map<Character,Integer> tMap=new HashMap<>(129,0.75f);

        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i),tMap.getOrDefault(t.charAt(i),0)+1);
        }
        counter=tMap.size();
        //开始主循环
        while (end<s.length()){
            //判断当前的end位置是否在tmap中存在
            if (tMap.containsKey(s.charAt(end))) {
                //如果存在的话就从tmap中踢掉一个
                tMap.put(s.charAt(end),tMap.get(s.charAt(end))-1);
                //如果当前位置减掉之后变成零了 就更新counter计数器
                if (tMap.get(s.charAt(end))==0) {
                    counter--;
                }
            }
            //继续执行遍历哟
            end++;
            //每次都可以判断下counter是否等于零 等于0的话说明当前的begin和end位置是符合条件的（t中所有元素在当前窗口都存在）
            //确定到这个窗口之后，需要将begin往前推，也就是窗口继续向前滑动
            while (counter==0){
                if (tMap.containsKey(s.charAt(begin))) {
                    tMap.put(s.charAt(begin),tMap.get(s.charAt(begin))+1);
                    if (tMap.get(s.charAt(begin))>0) {
                        counter++;
                    }
                }
                //判断下当前的窗口是否满足条件，这里的话只需要满足完全存在的条件也就是如果当前窗口定位到的是abcde 但是目标窗口是abe也可以返回
                if (end-begin<=len) {
                    len=end-begin;
                    target=s.substring(begin,end);
                }
                begin++;
            }
        }
        return target;
    }

    public static void main(String[] args) {
        new Solution().minWindow("ADOBECODEBANC","ABC");
    }
}