package Contest.Contest9.Problem1;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> hashMap= new HashMap<>();
        hashMap.put(0,1);
        int[] subSum=new int[nums.length+1];
        subSum[0]=0;
        int tempSum=0,count=0;
        //1.统计子串和
        for (int i = 0; i < nums.length; i++) {
            tempSum+=nums[i];
            subSum[i+1]=tempSum;
        }
        //2.遍历子串和
        for (int i = 1; i < subSum.length; i++) {
            count+=hashMap.getOrDefault(subSum[i]-k,0);
            hashMap.put(subSum[i],hashMap.getOrDefault(subSum[i],0)+1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subarraySum(new int[]{1},0));
    }
}