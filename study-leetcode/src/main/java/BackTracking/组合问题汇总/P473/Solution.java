package BackTracking.组合问题汇总.P473;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 输入: [1,1,2,2,2]
 * 输出: true
 *
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 */
class Solution {
    private int initTarget;
    private List<Integer> params;
    boolean[] selected;
    public boolean makesquare(int[] nums) {
        int sum=Arrays.stream(nums).sum();
        if (sum==0 || sum%4!=0) {
            return false;
        }
        params=Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        selected=new boolean[nums.length];
        initTarget=sum/4;
        return dfs(0,initTarget,4);
    }
    private boolean dfs(int start, int target,int count){
        if (count==0) {
            return true;
        }
        if (target<0){
            return false;
        }
        if (target==0) {
            return dfs(0,initTarget,count-1);
        }
        for (int i = start; i < params.size(); i++) {
            if (!selected[i]) {
                selected[i]=true;
                if (dfs(i+1,target-params.get(i),count)) {
                    return true;
                }
                selected[i]=false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().makesquare(new int[]{}));
        System.out.println(new Solution().makesquare(new int[]{2,2,2,2,2,6}));
        System.out.println(new Solution().makesquare(new int[]{1, 1, 2, 2, 2}));
        System.out.println(new Solution().makesquare(new int[]{3, 3, 3, 3, 4}));
    }
}