package BackTracking.P267;

import java.util.*;

class Solution {
    private List<String> result=new ArrayList();
    private boolean[] visited;
    public List<String> generatePalindromes(String s) {
        //aabb->ab aacbb->ab 寻找可以构建的多种可能性的字符串
        Map<Character,Integer> countMap=new HashMap();
        for (int i = 0; i < s.length(); i++) {
            Character key=s.charAt(i);
            countMap.put(key, countMap.getOrDefault(key, 0)+1);
        }
        //判断是否可构成回文串
        Iterator<Map.Entry<Character, Integer>> iterator = countMap.entrySet().iterator();
        String mid="";
        StringBuilder possible=new StringBuilder();
        int countSingle=0;
        while(iterator.hasNext()){
            Map.Entry<Character,Integer> next=iterator.next();
            Character key=next.getKey();
            Integer value=next.getValue();
            Integer time=value/2;
            while(time>0){
                possible.append(key);
                time--;
            }
            if(value%2!=0){
                countSingle++;
                mid=key+"";
            }
            if(countSingle>1){
                return result;
            }
        }
        //回溯possible可能组成的字符串
        int n=possible.length();
        visited=new boolean[n];
        backingTracking(possible.toString(), "");
        for (int i = 0; i < result.size(); i++) {
            StringBuilder current=new StringBuilder();
            current.append(result.get(i));
            current.append(mid).append(new StringBuilder(result.get(i)).reverse());
            result.set(i, current.toString());
        }
        return result;
    }
    private void backingTracking(String s,String temp){
        if(temp.length()==s.length()){
            result.add(temp);
        }
        Set<Character> set=new HashSet();
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i] && set.add(s.charAt(i))){
                String next=temp+s.charAt(i);
                visited[i]=true;
                backingTracking(s, next);
                visited[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generatePalindromes("aaa"));
        System.out.println(new Solution().generatePalindromes("aabb"));
        System.out.println(new Solution().generatePalindromes("abc"));
    }
}