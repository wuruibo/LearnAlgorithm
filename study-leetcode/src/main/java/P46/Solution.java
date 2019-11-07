package P46;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Backing tracking
 */
class Solution {
    //定义数组
    private int[] nums;
    private Set<Integer> set= new HashSet<>();
    private List<List<Integer>> result= new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        this.nums=nums;
        premuteBackTracking(new ArrayList<>(),0);
        return result;
    }
    public void premuteBackTracking(List<Integer> tempList,int start){
        if (tempList.size()==nums.length) {
            result.add(new ArrayList<>(tempList));
        }
        //全部都要循环一遍 碰到已经出现过的直接跳过
        for (int i = 0; i < nums.length; i++) {
            //如果已经遍历过了就跳过
            if (set.contains(nums[i])) {
                continue;
            }
            tempList.add(nums[i]);
            set.add(nums[i]);
            premuteBackTracking(tempList,i);
            tempList.remove(tempList.size()-1);
            set.remove(nums[i]);
        }
    }

    public static void main(String[] args) {
        int[] ints={1,2,3,4,5,6,7,8,9,0};
        new Solution().permute(ints);
    }
}