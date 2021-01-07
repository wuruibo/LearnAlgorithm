package Contest.Contest47.Problem2;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countPairs(int[] deliciousness) {
        long count=0;
        Map<Integer,Long> hashMap= new HashMap<>();
        for (int i : deliciousness) {
            for (int j = 0; j <= 21; j++) {
                count = (count + hashMap.getOrDefault((1 << j) - i, 0L)) % 1000000007;
            }
            hashMap.put(i, hashMap.getOrDefault(i, 0L) + 1);
        }
        return (int) count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countPairs(new int[]{1, 3, 5, 7, 9}));
    }
}