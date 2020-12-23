package Contest.Contest43.Problem3;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * 输入：nums = [1,-1,-2,4,-7,3], k = 2
 * 输出：7
 * 解释：你可以选择子序列 [1,-1,4,3] （上面加粗的数字），和为 7 。
 *
 * dp[i][j]表示从i位置跳到j位置 能到达的路径的最大和
 * dp[i][j]= Math.max(dp[i][j-1],dp[i][j-2],dp[i][j-k])+nums[j];
 */
class Solution {
    public int maxResult(int[] nums, int k) {
        //dp[i]表示跳到i位置的最大路径和
        int n=nums.length;
        TreeMap<Integer,Integer> treeMap= new TreeMap<>();
        int[] dp=new int[n];
        Arrays.fill(dp,Integer.MIN_VALUE);
        //保存下前k个的最大值
        for (int i = 0; i < n; i++) {
            if (i==0) {
                dp[i]=nums[i];
            }else {
                int preMax=treeMap.lastKey();
                dp[i]=Math.max(preMax+nums[i],dp[i]);
            }
            if (i>=k) {
                treeMap.put(dp[i-k],treeMap.get(dp[i-k])-1);
                if (treeMap.get(dp[i-k])==0) {
                    treeMap.remove(dp[i-k]);
                }
            }
            treeMap.put(dp[i],treeMap.getOrDefault(dp[i],0)+1);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxResult(new int[]{1, -1, -2, 4, -7, 3}, 2));
        System.out.println(new Solution().maxResult(new int[]{10,-5,-2,4,0,3}, 3));
        System.out.println(new Solution().maxResult(new int[]{1,-5,-20,4,-1,3,-6,-3}, 2));
    }
}