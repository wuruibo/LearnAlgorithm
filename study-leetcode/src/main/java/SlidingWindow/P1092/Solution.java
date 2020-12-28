package SlidingWindow.P1092;

/**
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * 输出：16
 * 解释：
 * 书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 *
 */
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int result=0,max=0;
        for (int i = 0; i < customers.length; i++) {
            result+=grumpy[i]==0?customers[i]:0;
        }
        //开始滑动窗口
        for (int j = 0,i=0; j < customers.length; j++) {
            while (j - i == X) {
                result-=grumpy[i]==1?customers[i]:0;
                i++;
            }
            result+=grumpy[j]==0?0:customers[j];
            max=Math.max(max,result);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
    }
}