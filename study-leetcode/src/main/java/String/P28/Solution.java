package String.P28;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int strStr(String haystack, String needle) {
        //1.空字符串为任何字符串的子串
        if(needle.length() ==0){
            return 0;
        }
        //2.根据needle字符串构造next数组
        int n=needle.length();
        int[] next=new int[n];
        for (int j=0,i = 1; i < n; i++) {
            if(needle.charAt(i)==needle.charAt(j)){
                next[i]=next[i-1]+1;
                j++;
            }else{
                while (j>0 && needle.charAt(i)!=needle.charAt(j)){
                    j=next[j-1];
                }
                if (needle.charAt(i)==needle.charAt(j)) {
                    next[i]=next[j]+1;
                    j++;
                }
            }
        }
        //3.根据next数组进行匹配
        for(int i=0,j=0;i<haystack.length();i++){
            //4.匹配到不相等的情况next数组一直往前回溯 直到相等or回到初始位置
            while (j>0 && needle.charAt(j) != haystack.charAt(i)){
                j=next[j-1];
            }
            if (needle.charAt(j)==haystack.charAt(i) && j==needle.length()-1){
                return i-needle.length()+1;
            }
            if (needle.charAt(j)==haystack.charAt(i)){
                j++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Map<String,String>> result=new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            Map<String,String> objectMap = new HashMap<>();
            objectMap.put(String.valueOf(i),String.valueOf(i));
            result.add(objectMap);
        }
/*        List<Map<String,String>> sbs=result.stream().filforEach(s->s.put("test","test"));
        for (StringBuilder sb : result) {
            System.out.print(sb);
            System.out.print("---");
            System.out.println();
        }*/
        StringBuilder keyWords = new StringBuilder("预估多少,");
        keyWords.insert(0,"确认完成称重吗？");
        if (keyWords.charAt(keyWords.length()-1)==',') {
            keyWords.deleteCharAt(keyWords.length()-1);
        }
        System.out.println(keyWords.toString());
        System.out.println(new Solution().strStr("baabbbbababbbabab","abbab"));
        System.out.println(new Solution().strStr("abc" ,"c"));
        System.out.println(new Solution().strStr("ababcaababcaabc" ,"ababcaabc"));
        System.out.println(new Solution().strStr("mississippi", "issip"));
        System.out.println(new Solution().strStr("hello", "ll"));
        System.out.println(new Solution().strStr("aaaabba", "bba"));
    }
}