package BitManipulation.P136;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map= new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i])==null){
                map.put(nums[i],1);
            }else {
                map.remove(nums[i]);
            }
        }
        return (Integer) map.keySet().toArray()[0];
    }

    public static void main(String[] args) {
        int[] ints={4,1,2,1,2};
        int[] ints1={
                2,2,1
        };

        System.out.println(new Solution().singleNumber(ints));
        System.out.println(new Solution().singleNumber(ints1));
    }
}