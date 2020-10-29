package HashTable.P274;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    public int hIndex(int[] citations) {
        List<Integer> sortedList=Arrays.stream(citations)
                .boxed()
                .sorted((a,b)->b-a)
                .collect(Collectors.toList());
        int i=0;
        while (i<sortedList.size() && sortedList.get(i) > i) {
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println(new Solution().hIndex(new int[]{100}));
    }
}