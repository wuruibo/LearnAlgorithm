package P567;

import java.util.HashMap;
import java.util.Map;

/**
 * sliding window
 * begin和end中间的部分为窗口 注意不包括begin和end
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //定义前后窗口
        int begin=0,end=0,counter;
        if (s1==null) {
            return true;
        }
        if (s2==null || s1.length()>s2.length()) {
            return false;
        }
        //将s1字符存到map
        Map<Character,Integer> sMap=new HashMap<>(s1.length()*2,0.75f);
        for (int i = 0; i < s1.length(); i++) {
            char charC=s1.charAt(i);
            sMap.put(charC,sMap.getOrDefault(charC,0)+1);
        }
        counter=sMap.size();
        //开始循环
        while (end<s2.length()){
            char endChar=s2.charAt(end);
            if (sMap.containsKey(endChar)) {
                sMap.put(endChar,sMap.get(endChar)-1);
                if (sMap.get(s2.charAt(end))==0) {
                    counter--;
                }
            }
            end++;
            while (counter==0){
                char beginChar=s2.charAt(begin);
                if (sMap.containsKey(beginChar)) {
                    sMap.put(beginChar,sMap.get(beginChar)+1);
                    if (sMap.get(beginChar)>0) {
                        counter++;
                    }
                }
                //判断满足条件返回
                if ((end-begin)==s1.length()) {
                    return true;
                }
                begin++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkInclusion("ab","eidbaooo"));
        System.out.println(new Solution().checkInclusion("ab","eeidboaoo"));
    }
}