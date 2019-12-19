package TwoPointer.P18;

import java.util.*;

/**
 * Example:
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        //define result
        List<List<Integer>> result= new ArrayList<>();
        List<List<Integer>> cResult= new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            //define tempResult
            List<Integer> tempResult=new ArrayList<>();
            tempResult.add(nums[i]);

            for (int j = nums.length-3; j >=i+1; j--) {
                tempResult.add(nums[j]);
                //define two pointer
                int left=j+1,right=nums.length-1,last=target-nums[i]-nums[j];

                while (left<right){
                    if (nums[left]+nums[right]<last) {
                        left++;
                    }else if(nums[left]+nums[right]>last){
                        right--;
                    }else {
                        tempResult.add(nums[left]);
                        tempResult.add(nums[right]);
                        result.add(new ArrayList<>(tempResult));
/*                        //在这里去除重复 减少后面通过hashmap来去重
                        while (left<right && nums[left]==nums[++left]);
                        while (left<right && nums[right]==nums[--right]);*/
                        left++;right--;

                        tempResult.remove(tempResult.size()-1);
                        tempResult.remove(tempResult.size()-1);
                    }
                }
                tempResult.remove(tempResult.size()-1);
            }
            tempResult.remove(tempResult.size()-1);
        }
        //result 去除重复 在上面进行了去重 这里可以注释掉
        Set<List<Integer>> set=new HashSet<>();
        for (List<Integer> list : result) {
            if (!set.contains(list)) {
                set.add(list);
                cResult.add(list);
            }
        }

        return cResult;
    }

    public static void main(String[] args) {
/*        int[] ints={1, 0, -1, 0, -2, 2};
        System.out.println(new Solution().fourSum(ints,0));*/
        int a=0;
        System.out.println(a==++a);
        System.out.println(a);
        int[] ints1={-3,-2,-1,0,0,1,2,3};
        System.out.println(new Solution().fourSum(ints1,0));
    }
}