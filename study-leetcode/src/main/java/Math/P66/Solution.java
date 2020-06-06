package Math.P66;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 *
 */
class Solution {
    public int[] plusOne(int[] digits) {
        int jinwei=0,yushu,second,first;
        int[] resultArray;
        List<Integer> result= new LinkedList<>();
        for (int i = digits.length - 1; i >= 0; i--) {
            first=digits[i];
            second=i==digits.length-1?1:0;

            yushu=(first+second+jinwei)%10;
            jinwei=(first+second+jinwei)/10;

            result.add(0,yushu);

        }
        if (jinwei!=0) {result.add(0,jinwei);}
        resultArray=new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            resultArray[i]=result.get(i);
        }
        return resultArray;
    }

    public static void main(String[] args) {
        int[] ints={4,3,2,1};
        Arrays.stream(new Solution().plusOne(ints)).forEach(integer-> System.out.println(integer));
        System.out.println();

        int[] ints1={9,9,9};
        Arrays.stream(new Solution().plusOne(ints1)).forEach(integer-> System.out.println(integer));
        System.out.println();
    }
}