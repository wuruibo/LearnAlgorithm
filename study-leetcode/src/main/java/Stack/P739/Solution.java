package Stack.P739;

/**
 * 时间复杂度O(N^2)
 * 空间复杂度O(1)
 * 两边循环
 */
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] result=new int[T.length];
        for (int x = 0; x < T.length; x++) {
            for (int y = x+1; y < T.length; y++) {
                if (T[x]<T[y]) {
                    result[x]=y-x;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints={73, 74, 75, 71, 69, 72, 76, 73};
        new Solution().dailyTemperatures(ints);
    }
}