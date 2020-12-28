package Contest.Contest44.Problem1;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public boolean halvesAreAlike(String s) {
        int n=s.length();
        Set<Character> set= Arrays.stream(new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}).collect(Collectors.toSet());
        return count(s.substring(0,n/2),set)==count(s.substring(n/2,n),set);
    }
    private int count(String s,Set<Character> set){
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().halvesAreAlike("book"));
        System.out.println(new Solution().halvesAreAlike("textbook"));
        System.out.println(new Solution().halvesAreAlike("MerryChristmas"));
        System.out.println(new Solution().halvesAreAlike("AbCdEfGh"));
    }
}