package Greedy.P1567.前缀和;

import java.util.HashMap;
import java.util.Map;

class Solution {
    //公用的
    private int index = 0;
    public int getMaxLen(int[] nums) {
        int maxPositiveLength = 0;
        while(index < nums.length){
            int positiveLength = getMaxPosLen(nums);
            if(positiveLength > maxPositiveLength){
                maxPositiveLength = positiveLength;
            }
        }
        return maxPositiveLength;
    }
    //没有零的数组
    private int getMaxPosLen(int[] nums){
        int maxPosLen = 0;
        //转化为一个前缀积的正负号关系
        Map<Integer, Integer> map = new HashMap<>();
        //哨兵
        map.put(1, index-1);
        int product = 1;
        while(index < nums.length && nums[index] != 0){
            product *= nums[index] > 0 ? 1 : -1;
            if(map.containsKey(product)){
                int posLen = index - map.get(product);
                maxPosLen = posLen > maxPosLen ? posLen : maxPosLen;
            }else{
                map.put(product, index);
            }
            index++;
        }
        index++;//跳过0，或者超出nums.length
        return maxPosLen;
    }
}
