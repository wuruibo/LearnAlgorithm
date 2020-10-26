package HashTable.P290;

import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strings=s.split(" ");
        if (pattern.length()!=strings.length) {
            return false;
        }
        int[] hash=new int[26];
        Arrays.fill(hash,-1);
        for (int i = 0; i < pattern.length(); i++) {
            int index=pattern.charAt(i)-'a';
            if (hash[index]==-1) {
                hash[index]=i;
            }else {
                //判断是否相等
                if (!equalsPattern(strings,hash[index],i)) {
                    return false;
                }
            }
        }
        int size=Arrays.stream(strings).collect(Collectors.groupingBy(String::toString,Collectors.counting())).size();
        long count=Arrays.stream(hash).filter(i->i>=0).count();
        return size==count?true:false;
    }
    private boolean equalsPattern(String[] strings,int i,int j){
        return strings[i].equals(strings[j]);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordPattern("abba", "dog cat cat fish"));
        System.out.println(new Solution().wordPattern("abba", "dog cat cat dog"));
        System.out.println(new Solution().wordPattern("abba", "dog dog dog dog"));
    }
}