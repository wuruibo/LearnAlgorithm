
本文主要针对Backtracking类型的算法进行总结归纳解题模板。

P22. Generate Parentheses

问题描述（难度中等）

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

    [
      "((()))",
      "(()())",
      "(())()",
      "()(())",
      "()()()"
    ]

BackTracking代码

思路过程是，我们有n个左括号，n个右括号，第一次只能放一个左括号，第二次可以选择放一个右括号或者左括号。以此类推，当n>0时都可以放左括号，当m>n时都可以放右括号，最后递归的结束条件是m和n都减到零。

    package P22;
    
    import java.util.ArrayList;
    import java.util.List;
    
    /**
     * 时间复杂度O(N^2)
     * 空间复杂度O(N)
     */
    class Solution {
        private List<String> result=new ArrayList<>();
        public List<String> generateParenthesis(int n) {
            generateParenthesisMnes("",n,n);
            return this.result;
        }
        public void generateParenthesisMnes(String str,int n,int m){
            if (n==0 && m==0) {
                this.result.add(str);
                return;
            }
            if (n>0) {
                generateParenthesisMnes(str+'(',n-1,m);
            }
            if (m>n) {
                generateParenthesisMnes(str+')',n,m-1);
            }
            return;
        }
    
        public static void main(String[] args) {
            new Solution().generateParenthesis(3);
        }
    }

P78. Subsets

问题描述（难度中等）

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

    Input: nums = [1,2,3]
    Output:
    [
      [3],
      [1],
      [2],
      [1,2,3],
      [1,3],
      [2,3],
      [1,2],
      []
    ]

Backtracking解题代码

回溯法可以通过模拟树，遍历各种情况，本题可以得到下面的图，当然前提是将nums数组进行排序：



得到代码如下：

    package P78;
    
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

P90. Subsets II

问题描述（难度中等）

Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

    Input: [1,2,2]
    Output:
    [
      [2],
      [1],
      [1,2,2],
      [2,2],
      [1,2],
      []
    ]

Backtracking回溯代码

比较第一题，主要是会出现重复的数字，重复数字出现的只需要跳过，不需要继续回溯。

    package P90;
    
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

P46. Permutations

问题描述（难度中等）

Given a collection of distinct integers, return all possible permutations.

Example:

    Input: [1,2,3]
    Output:
    [
      [1,2,3],
      [1,3,2],
      [2,1,3],
      [2,3,1],
      [3,1,2],
      [3,2,1]
    ]

BackTracking解题代码

本题break的条件有所不同，本题需要在遍历到根节点之后才记录当前数组是有效的，另外在每次的回溯过程中需要过滤已经回溯过的字段，一开始想到用Set去存储，进行重复的判断。实际上用只需要判断前缀数组是否包含即可。

    package P46;
    
    import java.util.ArrayList;
    import java.util.List;
    
    /**
     * @autor yeqiaozhu.
     * @date 2019-11-07
     */
    public class Soulution2 {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            // Arrays.sort(nums); // not necessary
            backtrack(list, new ArrayList<>(), nums);
            return list;
        }
        private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
            if(tempList.size() == nums.length){
                list.add(new ArrayList<>(tempList));
            } else{
                for(int i = 0; i < nums.length; i++){
                    if(tempList.contains(nums[i])) continue; // element already exists, skip
                    tempList.add(nums[i]);
                    backtrack(list, tempList, nums);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }


