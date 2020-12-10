package Contest.Contest41.Problem4;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<String,Integer> dpMap= new HashMap<>();
    public int minimumIncompatibility(int[] nums, int k) {
        return dfs(0,nums,k);
    }
    private int dfs(int select,int[] nums,int k){
        if (k==0) {
            return 0;
        }
        String key=select+""+k;
        if (dpMap.containsKey(key)) {
            return dpMap.get(key);
        }
        int result=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if ((select&(1<<i))==0 && (select&(1<<j))==0 && nums[i]!=nums[j]) {
                    select^=1<<i;
                    select^=1<<j;
                    int subMin=dfs(select,nums,k-1);
                    if (subMin!=-1) {
                        result=Math.min(result,Math.abs(nums[i]-nums[j])+subMin);
                    }
                    select^=1<<i;
                    select^=1<<j;
                }
            }
        }
        result=result==Integer.MAX_VALUE?-1:result;
        dpMap.put(key,result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumIncompatibility(new int[]{1, 2, 1, 4}, 2));
        System.out.println(new Solution().minimumIncompatibility(new int[]{6,3,8,1,3,1,2,2}, 4));
        System.out.println(new Solution().minimumIncompatibility(new int[]{5,3,3,6,3,3}, 3));
    }
}