package HashTable.P594;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> indexMap= new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            indexMap.put(nums[i],indexMap.getOrDefault(nums[i],0)+1);
        }
        int size=indexMap.entrySet().size();
        Integer[] keys=indexMap.keySet().toArray(new Integer[size]);
        Arrays.sort(keys);
        int max=0;
        for (int i = 1; i < keys.length; i++) {
            if (keys[i]-keys[i-1]==1) {
                max=Math.max(indexMap.get(keys[i-1])+indexMap.get(keys[i]),max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
    }
}