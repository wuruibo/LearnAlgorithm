package Array.前缀和.P1590;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个正整数数组 nums，请你移除 最短 子数组（可以为 空），使得剩余元素的 和 能被 p 整除。 不允许 将整个数组都移除。
 *
 * 请你返回你需要移除的最短子数组的长度，如果无法满足题目要求，返回 -1 。
 *
 * 子数组 定义为原数组中连续的一组元素。
 * 示例 1：
 *
 * 输入：nums = [3,1,4,2], p = 6
 * 输出：1
 * 解释：nums 中元素和为 10，不能被 p 整除。我们可以移除子数组 [4] ，剩余元素的和为 6 。
 * 示例 2：
 *
 * 输入：nums = [6,3,5,2], p = 9
 * 输出：2
 * 解释：我们无法移除任何一个元素使得和被 9 整除，最优方案是移除子数组 [5,2] ，剩余元素为 [6,3]，和为 9 。
 * 示例 3：
 *
 * 输入：nums = [1,2,3], p = 3
 * 输出：0
 * 解释：和恰好为 6 ，已经能被 3 整除了。所以我们不需要移除任何元素。
 * 示例  4：
 *
 * 输入：nums = [1,2,3], p = 7
 * 输出：-1
 * 解释：没有任何方案使得移除子数组后剩余元素的和被 7 整除。
 * 示例 5：
 *
 * 输入：nums = [1000000000,1000000000,1000000000], p = 3
 * 输出：0
 *
 */
class Solution {
    public int minSubarray(int[] nums, int p) {
        //计算前缀和 每个位置都是当前位置的前缀和取余数p
        int[] subSums=new int[nums.length+1];
        for (int i = 1; i < subSums.length; i++) {
            subSums[i]=(subSums[i-1]%p+nums[i-1]%p)%p;
        }
        if (subSums[nums.length]==0) {
            return 0;
        }
        int min=Integer.MAX_VALUE;
        //需要匹配的子数组需要符合标准 取余p的值==全部数组的和取余p的值相等
        //前缀和取余数p数组遍历 每次存一下index的位置 贪心覆盖
        Map<Integer,Integer> subMap=new HashMap<>(16);
        for (int i = 0; i < subSums.length; i++) {
            //确定目标值 subSum[i]-subMap.get(target)=subSum[subSum.length] ----> target=subSum[i]-subSum[subSum.length]
            int target=(int)(long)(subSums[i]-subSums[nums.length]+p)%p;
            if (subMap.containsKey(target)) {
                min=Math.min(min,i-subMap.get(target));
            }
            subMap.put(subSums[i],i);
        }
        return (min==Integer.MAX_VALUE || min==nums.length)?-1:min;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minSubarray(new int[]{3, 1, 4, 2}, 6));
        System.out.println(new Solution().minSubarray(new int[]{6,3,5,2}, 9));
        System.out.println(new Solution().minSubarray(new int[]{1,2,3}, 3));
        System.out.println(new Solution().minSubarray(new int[]{1,2,3}, 7));
        System.out.println(new Solution().minSubarray(new int[]{1000000000,1000000000,1000000000}, 3));
    }
}