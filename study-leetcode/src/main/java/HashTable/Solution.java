package HashTable;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {

        StringBuilder newS=new StringBuilder();
        StringBuilder newP=new StringBuilder();
        buildString(s,newS);
        buildString(t,newP);

        return newP.toString().equals(newS.toString());
    }

    public void buildString(String input,StringBuilder s){
        Map<Character,Integer> sMap= new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char current=input.charAt(i);
            if (sMap.containsKey(current)) {
                s.append(sMap.get(current));
            }else{
                s.append(sMap.size()+1);
                sMap.put(current,sMap.size()+1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isIsomorphic("paper","title"));
    }
}