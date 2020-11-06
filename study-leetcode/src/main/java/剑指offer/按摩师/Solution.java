package 剑指offer.按摩师;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer,Integer> dpMap= new HashMap<>();
    public int massage(int[] nums) {
        return dfs(nums,0);
    }
    private int dfs(int[] nums,int i){
        if (i>nums.length-1) {
            return 0;
        }
        if (dpMap.containsKey(i)) {
            return dpMap.get(i);
        }
        //选择当前节点
        int leftMax=dfs(nums,i+2)+nums[i];
        int rightMax=dfs(nums,i+1);
        int max=Math.max(leftMax,rightMax);
        dpMap.put(i,max);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().massage(new int[]{1,2,3,1}));
        System.out.println(new Solution().massage(new int[]{2,7,9,3,1}));
        System.out.println(new Solution().massage(new int[]{2,1,4,5,3,1,1,3}));
    }
}