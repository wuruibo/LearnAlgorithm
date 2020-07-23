package Stack.P1063;

import java.util.Stack;

/**
 * 解题思路
 * 单调栈，维护栈中元素单调递增。加入元素时，如果栈顶元素比当前元素小，那么久说明以栈顶元素为左端点的满足条件的数组个数为i - st[top()]个。
 *
 * 每次出栈相当于就得到了以栈顶元素为左端点的所有可行的区间个数。
 *
 * 在数组末尾加入一个最小值可以让最后将栈排空。
 *
 * 时间复杂度O(n)
 * 空间复杂度o(n)
 *
 */
public class UsingStack {
    public int validSubarrays(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i=0;i<nums.length;i++){
            while(!stack.empty()&&nums[stack.peek()]>nums[i])
                res+=i-stack.pop();
            stack.push(i);
        }

        while(!stack.empty())
            res+=nums.length - stack.pop();
        return res;
    }
}
