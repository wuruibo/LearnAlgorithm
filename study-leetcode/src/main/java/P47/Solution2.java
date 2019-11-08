package P47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @autor yeqiaozhu.
 * @date 2019-11-07
 */
public class Solution2 {
    private List<List<Integer>> list = new ArrayList<>();
    private int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums=nums;
        Arrays.sort(nums);
        backtrack(new ArrayList<>(),new boolean[nums.length]);
        return list;
    }

    private void backtrack(List<Integer> tempList,  boolean [] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(tempList,used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] ints={1,1,2};
        new Solution2().permuteUnique(ints);
    }
}
