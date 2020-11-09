package Contest.Contest38.Problem2;

import java.util.HashSet;
import java.util.Set;

class Solution {
    private final int number=26;
    public int minDeletions(String s) {
        int[] hash=new int[26];
        for (char c : s.toCharArray()) {
            hash[c-'a']++;
        }
        int steps=0;
        Set<Integer> set= new HashSet<>();
        for (int i = 0; i < number; i++) {
            int current=hash[i];
            while (current != 0 && set.contains(current)) {
                steps++;
                current--;
            }
            set.add(current);
        }
        return steps;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minDeletions("aab"));
        System.out.println(new Solution().minDeletions("aaabbbcc"));
        System.out.println(new Solution().minDeletions("ceabaacb"));
    }
}