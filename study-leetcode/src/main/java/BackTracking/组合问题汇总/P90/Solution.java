package BackTracking.组合问题汇总.P90;

import java.util.*;

class Solution {
    private int[] nums;
    private List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums=nums;
        Arrays.sort(nums);
        subsetsWithDupBacking(new ArrayList<>(),0);
        return result;
    }
    //回溯函数参数如何确定 1.返回的数据类型 2.子结构
    //这里需要返回列表，同时每次子递归都需要有nums.length-start次的递归次数
    public void subsetsWithDupBacking(List<Integer> tempList,int start){
        result.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) continue;
            tempList.add(nums[i]);
            subsetsWithDupBacking(tempList,i+1);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] ints={1,2,2};
        new Solution().subsetsWithDup(ints);
    }
}