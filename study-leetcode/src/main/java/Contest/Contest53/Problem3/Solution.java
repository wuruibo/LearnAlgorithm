package Contest.Contest53.Problem3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> hashMap=new HashMap<>(12);
        for (int i = 0; i < knowledge.size(); i++) {
            List<String> cur=knowledge.get(i);
            hashMap.put(cur.get(0),cur.get(1));
        }
        StringBuilder result = new StringBuilder();
        int i=0;
        while (i <s.length()) {
            if(s.charAt(i)=='('){
                int j=i+1;
                while (s.charAt(j)!=')'){
                    j++;
                }
                String temp=s.substring(i+1,j);
                if (hashMap.containsKey(temp)) {
                    result.append(hashMap.get(temp));
                }else {
                    result.append("?");
                }
                i=j+1;
            }else {
                result.append(s.charAt(i++));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {

    }
}