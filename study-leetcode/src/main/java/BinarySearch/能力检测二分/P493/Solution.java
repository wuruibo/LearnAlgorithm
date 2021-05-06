package BinarySearch.能力检测二分.P493;


import java.util.TreeMap;

/**
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 * 你需要返回给定数组中的重要翻转对的数量。
 *
 * 输入: [1,3,2,3,1]
 * 输出: 2
 */
class Solution {
    public int reversePairs(int[] nums) {
        int count=0;
        TreeMap<Long,Integer> treeMap=new TreeMap<>();
        for (int j = 0; j < nums.length; j++) {
            //1.找到j位置的对称对
            count+=treeMap.tailMap(2*Long.valueOf(nums[j]),false)
                    .values()
                    .stream()
                    .mapToInt(Integer::intValue)
                    .sum();
            //2.往treeMap中加入元素
            treeMap.put(Long.valueOf(nums[j]),treeMap.getOrDefault(Long.valueOf(nums[j]),0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().reversePairs(new int[]{1, 3, 2, 3, 1}));
        //System.out.println(new Solution().reversePairs(new int[]{2,4,3,5,1}));
        //System.out.println(new Solution().reversePairs(new int[]{5,4,3,2,1}));
        System.out.println(new Solution().reversePairs(new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647}));
    }
}