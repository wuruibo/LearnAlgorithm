package BackTracking.P78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Backtracking
 */
class Solution {
    private int[] nums;
    private List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        this.nums=nums;
        //这里排序，可以省去去重这一步
        Arrays.sort(nums);
        subSetsFind(new ArrayList<>(),0);
        return result;
    }
    public void subSetsFind(List<Integer> tempList,int start){
        result.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            //增加当前元素到临时数组中
            tempList.add(nums[i]);
            //继续往下回溯
            subSetsFind(tempList,i+1);
            //将增加的元素取消掉，因为要继续回溯别的情况
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] ints={1,2,3};
        new Solution().subsets(ints);
    }
}