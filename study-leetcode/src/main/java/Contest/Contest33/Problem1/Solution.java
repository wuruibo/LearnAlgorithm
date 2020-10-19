package Contest.Contest33.Problem1;

import java.util.Arrays;

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        //hash存储最小索引值
        int[] hash=new int[26];
        Arrays.fill(hash,-1);
        int max=-1;
        for (int i = 0; i < s.length(); i++) {
            int index=s.charAt(i)-'a';
            if (hash[index]==-1) {
                hash[index]=i;
            }else {
                max= Math.max(max,i-hash[index]-1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxLengthBetweenEqualCharacters("aa"));
        System.out.println(new Solution().maxLengthBetweenEqualCharacters("abca"));
        System.out.println(new Solution().maxLengthBetweenEqualCharacters("cbzxy"));
        System.out.println(new Solution().maxLengthBetweenEqualCharacters("cabbac"));
    }
}