package P338;

import CommonUtils.ArrayUtils;

/**
 * 动态规划
 * 避免计算重复子问题
 */
class Solution {
    public int[] countBits(int num) {
        int[] counts=new int[num+1];
        for (int i = 1; i < num+1; i++) {
            //这里注意+的优先级大于&的优先级
            counts[i]=counts[i>>1]+(i&1);
        }
        return counts;
    }

    public static void main(String[] args) {
        ArrayUtils.getInstance().printIntArray(new Solution().countBits(5));
    }
}