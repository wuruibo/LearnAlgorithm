package DynamicProgramming.P312;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<BitSet, Integer> map = new HashMap<>();
    //记忆化递归
    private int recursive(int[] nums, BitSet bitset){

        if(map.containsKey(bitset)){
            return map.get(bitset);
        }

        int max = 0;
        //如果当前气球未戳破，　则可以戳破
        for(int i = 0; i < nums.length; i++){
            if(!bitset.get(i)){
                bitset.flip(i); //戳破当前气球
                int left = bitset.previousClearBit(i);
                int right = bitset.nextClearBit(i);
                int leftVal = left == -1 ? 1 : nums[left];
                int rightVal = right == nums.length ? 1: nums[right];
                //System.out.println(bitset);
                //System.out.println(nums[i] * leftVal * rightVal);
                max = Math.max(max, nums[i] * leftVal * rightVal + recursive(nums, bitset));
                bitset.flip(i);
            }
        }
        map.put(bitset, max);
        return max;
    }

    public int maxCoins(int[] nums) {
        //使用位向量，　如果当前位为false, 表示当前气球尚未被戳破
        BitSet bitset = new BitSet(nums.length);
        return recursive(nums, bitset);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxCoins(new int[]{3,1,5,8}));
        System.out.println(new Solution().maxCoins(new int[]{7,9,8,0,7,1,3,5,5,2}));
        System.out.println(new Solution().maxCoins(new int[]{8,2,6,8,9,8,1,4,1,5,3,0,7,7,0,4,2,2,5}));
    }
}