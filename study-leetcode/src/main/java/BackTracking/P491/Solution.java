package BackTracking.P491;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> findSubsequences(int[] nums) {
        result= new ArrayList<>();
        dfs(nums,0,new ArrayList<>());
        return result;
    }
    private void dfs(int[] nums,int start,List<Integer> temp){
        Set<Integer> set= new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            int last=temp.size()==0?-101:temp.get(temp.size()-1);
            if (nums[i]>=last && set.add(nums[i])) {
                temp.add(nums[i]);
                if (temp.size()>=2) {
                    result.add(new ArrayList<>(temp));
                }
                dfs(nums,i+1,temp);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findSubsequences(new int[]{4,3,2,1}));
        System.out.println(new Solution().findSubsequences(new int[]{4, 6, 7, 7}));
        System.out.println(new Solution().findSubsequences(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}));
    }
}