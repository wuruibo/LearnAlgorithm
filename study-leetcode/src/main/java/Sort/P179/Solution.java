package Sort.P179;

import java.util.Arrays;
import java.util.Objects;

class Solution {
    public String largestNumber(int[] nums) {
       String value=Arrays.stream(nums)
               .boxed()
               .map(Objects::toString)
               .sorted((a,b)->(b+a).compareTo(a+b))
               .reduce((a, b)->a+b)
               .get();
       return value.matches("[0]*")?"0":value;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestNumber(new int[]{10,2}));
        System.out.println(new Solution().largestNumber(new int[]{3,30,34,5,9}));
        System.out.println(new Solution().largestNumber(new int[]{1}));
        System.out.println(new Solution().largestNumber(new int[]{10}));
        System.out.println(new Solution().largestNumber(new int[]{0,0}));
    }
}