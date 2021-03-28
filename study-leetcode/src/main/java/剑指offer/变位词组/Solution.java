package 剑指offer.变位词组;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result= new ArrayList<>();
        result.addAll(Arrays.stream(strs).collect(Collectors.groupingBy(str -> {
            int[] hash = new int[26];
            for (int i = 0; i < str.length(); i++) {
                hash[str.charAt(i) - 'a']++;
            }
            return Arrays.stream(hash)
                    .boxed()
                    .map(Objects::toString)
                    .reduce((a, b) -> a + "-" + b);
        })).values());
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}