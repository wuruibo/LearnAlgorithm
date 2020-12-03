package 剑指offer.P45;

import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String minNumber(int[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((o1, o2) -> (o1 + o2).compareTo(o2 + o1))
                .collect(Collectors.joining());
    }
}