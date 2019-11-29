package WaitingCollect.P47;

import java.util.*;

class Solution {
    private Map<Integer,Integer> hashMap=new HashMap<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        //初始化进入hashMap
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i],hashMap.getOrDefault(nums[i],0)+1);
        }
        Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(hashMap.get(nums[i])<=0 || (i>0 && nums[i]==nums[i-1])) continue; // element already exists, skip
                tempList.add(nums[i]);
                hashMap.put(nums[i],hashMap.get(nums[i])-1);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
                hashMap.put(nums[i],hashMap.get(nums[i])+1);
            }
        }
    }

    public static void main(String[] args) {
        int[] ints={3,3,0,3};
        new Solution().permuteUnique(ints);
    }
}