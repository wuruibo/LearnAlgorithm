package Contest.Contest11.Problem1;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 * 示例 2:
 *
 * 输入: [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 *
 *
 * 注意: 给定的二进制数组的长度不会超过50000。
 */
class Solution {
    public int findMaxLength(int[] nums) {
        //step1 将0转换成-1 变成求和为零的最大子数组
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0) {
                nums[i]=-1;
            }
        }
        //step1 统计前缀和
        int[] subSum=new int[nums.length+1];
        int tempSum=0;
        for (int i = 1; i <= nums.length; i++) {
            tempSum+=nums[i-1];
            subSum[i]=tempSum;
        }
        //遍历前缀和找到最大长度
        Map<Integer,Integer> subMap= new HashMap<>();
        int maxSub=0;
        for (int i = 0; i < subSum.length; i++) {
            int rightSub=subSum[i];
            if (subMap.containsKey(rightSub)) {
                Integer j=subMap.get(rightSub);
                maxSub=Math.max(maxSub,i-j);
            }else {
                subMap.put(rightSub, i);
            }
        }
        return maxSub;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMaxLength(new int[]{1}));
    }
}