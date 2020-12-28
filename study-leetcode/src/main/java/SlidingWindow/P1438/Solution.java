package SlidingWindow.P1438;

import java.util.TreeMap;

/**
 * 输入：nums = [8,2,4,7], limit = 4
 * 输出：2
 * 解释：所有子数组如下：
 * [8] 最大绝对差 |8-8| = 0 <= 4.
 * [8,2] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
 * [2] 最大绝对差 |2-2| = 0 <= 4.
 * [2,4] 最大绝对差 |2-4| = 2 <= 4.
 * [2,4,7] 最大绝对差 |2-7| = 5 > 4.
 * [4] 最大绝对差 |4-4| = 0 <= 4.
 * [4,7] 最大绝对差 |4-7| = 3 <= 4.
 * [7] 最大绝对差 |7-7| = 0 <= 4.
 * 因此，满足题意的最长子数组的长度为 2 。
 *
 */
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        if (nums.length==0) {
            return 0;
        }
        TreeMap<Integer,Integer> treeMap=new TreeMap<>();
        treeMap.put(nums[0],1);
        int result=Integer.MIN_VALUE;
        for (int j = 1,i=0;j <= nums.length;j++) {
            while (treeMap.lastKey() - treeMap.firstKey() > limit) {
                treeMap.put(nums[i],treeMap.get(nums[i])-1);
                if (treeMap.get(nums[i])==0) {
                    treeMap.remove(nums[i]);
                }
                i++;
            }
            if (nums.length>j) {
                treeMap.put(nums[j],treeMap.getOrDefault(nums[j],0)+1);
            }
            result=Math.max(result,j-i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestSubarray(new int[]{2,2,2,4,4,2,2}, 0));
        System.out.println(new Solution().longestSubarray(new int[]{8, 2, 4, 7}, 4));
        System.out.println(new Solution().longestSubarray(new int[]{10,1,2,4,7,2}, 5));
    }
}