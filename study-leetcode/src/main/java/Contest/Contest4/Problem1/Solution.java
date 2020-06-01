package Contest.Contest4.Problem1;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private Integer max=Integer.MIN_VALUE;
    public int maxProduct(int[] nums) {
        backTracking(nums, new ArrayList<>(),0,nums.length-1);

        return max;
    }
    private void backTracking(int[] nums,List<Integer> temp,int start,int end){
        if (temp.size()==2) {
            max=Math.max(max,(temp.get(0)-1)*(temp.get(1)-1));
            return;
        }
        for (int i = start; i <= end; i++) {
            temp.add(nums[i]);
            backTracking(nums,temp,i+1,end);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] A={3,4,5,2};
        System.out.println(new Solution().maxProduct(A));

        int[] B={1,5,4,5};
        System.out.println(new Solution().maxProduct(B));


        int[] C={3,7};
        System.out.println(new Solution().maxProduct(C));
    }
}