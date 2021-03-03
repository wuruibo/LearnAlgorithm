package Contest.Contest50.Problem1;

import java.util.Arrays;

class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int[] hash=new int[45];
        for (int i = lowLimit; i <= highLimit; i++) {
            int count=count(i);
            hash[count-1]++;
        }
        return Arrays.stream(hash).max().getAsInt();
    }
    private int count(int limit){
        int count=0;
        while (limit!=0){
            count+=limit%10;
            limit/=10;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countBalls(1, 10));
        System.out.println(new Solution().countBalls(5, 15));
        System.out.println(new Solution().countBalls(19, 28));
    }
}