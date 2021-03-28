package BinarySearch.能力检测二分.P327;

import java.util.TreeMap;

class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        //1.统计前缀和并加入到treeMap中
        TreeMap<Long,Integer> treeMap=new TreeMap();
        treeMap.put(0L,1);
        Long preSum=0L;
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            preSum+=nums[i];
            //2.统计以当前位置结尾的 符合条件的区间和的个数
            Long right= Long.valueOf(preSum-lower);
            Long left= Long.valueOf(preSum-upper);
            count += treeMap.subMap(left, true,right,true).values()
                    .stream()
                    .mapToInt(Integer::intValue)
                    .sum();
            treeMap.put(preSum, treeMap.getOrDefault(preSum, 0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countRangeSum(new int[]{-2, 5, -1}, -2, 2));
        System.out.println(new Solution().countRangeSum(new int[]{2147483647,-2147483648,-1,0}, -1,0));
    }
}