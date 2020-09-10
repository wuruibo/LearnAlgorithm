package Array.前缀和.P325;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个数组 nums 和一个目标值 k，找到和等于 k 的最长子数组长度。如果不存在任意一个符合要求的子数组，则返回 0。
 *
 * 注意:
 *  nums 数组的总和是一定在 32 位有符号整数范围之内的。
 *
 * 示例 1:
 *
 * 输入: nums = [1, -1, 5, -2, 3], k = 3
 * 输出: 4
 * 解释: 子数组 [1, -1, 5, -2] 和等于 3，且长度最长。
 * 示例 2:
 *
 * 输入: nums = [-2, -1, 2, 1], k = 1
 * 输出: 2
 * 解释: 子数组 [-1, 2] 和等于 1，且长度最长。
 * 进阶:
 * 你能使时间复杂度在 O(n) 内完成此题吗?
 *
 */
class Solution {
    /**
     * 前缀和
     * @param nums
     * @param k
     * @return
     */
    public int maxSubArrayLen(int[] nums, int k) {
        //构造前缀和
        int[] subSum=new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            subSum[i+1]=nums[i]+subSum[i];
        }
        //遍历前缀和 同时构建Map key：前缀和 value：index索引位置
        Map<Integer,Integer> subMap= new HashMap<>(16);
        int maxLength=0;
        for (int j = 0; j < subSum.length; j++) {
            //需要在map中匹配的剩余值
            int target=subSum[j]-k;
            //如果能匹配到剩余值 说明当前窗口满足和为k 取一次最大值
            if (subMap.containsKey(target)) {
                Integer index=subMap.get(target);
                maxLength=Math.max(maxLength,j-index);
            }
            //如果当前前缀和并未出现过 加入作为当前前缀和的最优索引 如果出现过不能覆盖 (贪心思想贪的是最小索引)
            if (!subMap.containsKey(subSum[j])) {
                subMap.put(subSum[j],j);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3));
        System.out.println(new Solution().maxSubArrayLen(new int[]{-2, -1, 2, 1}, 1));
        System.out.println(new Solution().maxSubArrayLen(new int[]{-2, -1, 2, 1}, 11));
    }
}