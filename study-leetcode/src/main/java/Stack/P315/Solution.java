package Stack.P315;

import java.util.LinkedList;
import java.util.List;

/**
 * 输入：nums = [5,2,6,1]
 * 输出：[2,1,1,0]
 * 解释：
 * 5 的右侧有 2 个更小的元素 (2 和 1)
 * 2 的右侧仅有 1 个更小的元素 (1)
 * 6 的右侧有 1 个更小的元素 (1)
 * 1 的右侧有 0 个更小的元素
 *
 */
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result=new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int count=0;
            for (int j = i; j < nums.length; j++) {
                if (nums[i]>nums[j]) {
                    count++;
                }
            }
            result.add(0,count);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countSmaller(new int[]{5,2,6,1}));
    }
}