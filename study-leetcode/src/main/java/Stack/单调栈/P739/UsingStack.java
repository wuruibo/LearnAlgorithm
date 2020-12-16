package Stack.单调栈.P739;

import java.util.Stack;

/**
 * 时间复杂度O(N)
 * 空间复杂度O(N)
 * using stack
 * @autor yeqiaozhu.
 * @date 2019-10-25
 */
public class UsingStack {
    public int[] dailyTemperatures(int[] T) {
        int[] result=new int[T.length];
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i]>T[stack.peek()]){
                int frontIndex=stack.pop();
                result[frontIndex]=i-frontIndex;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints={73, 74, 75, 71, 69, 72, 76, 73};
        new UsingStack().dailyTemperatures(ints);
    }


}
