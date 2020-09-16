package DynamicProgramming.P368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 图片讲解较为详细 需要记录结果集的可以用List[] dp
 * https://leetcode-cn.com/problems/largest-divisible-subset/solution/368-zui-da-zheng-chu-zi-ji-dp-shi-jian-fu-za-du-on/
 */
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums){
        Arrays.sort(nums);
        int n = nums.length;
        if(n == 0) {
            return new ArrayList();
        }
        List[] dp = new List[n];
        dp[0] = new ArrayList();
        dp[0].add(nums[0]);
        List<Integer> ans = dp[0];
        for(int i = 1; i < n; i++){
            dp[i] = new ArrayList();
            dp[i].add(nums[i]);

            for(int k = 0; k < i; k++){
                if(nums[i] % nums[k] == 0){
                    if(dp[i].size() < dp[k].size() + 1){
                        dp[i] = new ArrayList(dp[k]);
                        dp[i].add(nums[i]);
                    }
                }
            }
            if(ans.size() < dp[i].size()) {
                ans = dp[i];
            }
        }
        return ans;

    }
}