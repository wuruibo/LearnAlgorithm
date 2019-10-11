package P169;

import java.util.HashMap;
import java.util.Map;

/**
 * 时间复杂度O(N)
 * 空间复杂度O(N)
 * Using hash
 */
class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length==0) {
            return 0;
        }
        Map<Integer,Integer> integerMap=new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if(integerMap.containsKey(nums[i])){
                Integer value=integerMap.get(nums[i]);
                integerMap.put(nums[i],++value);
                if(value>nums.length/2){
                    return nums[i];
                }
            }else {
                integerMap.put(nums[i],1);
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int[] ints={2,2,1,1,1,2,2};
        System.out.println(new Solution().majorityElement(ints));

        int[] ints1={3,2,3};
        System.out.println(new Solution().majorityElement(ints1));

        int[] ints2={3};
        System.out.println(new Solution().majorityElement(ints2));
    }
}