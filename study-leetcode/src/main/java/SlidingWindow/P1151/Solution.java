package SlidingWindow.P1151;

import java.util.Arrays;

/**
 * 输入：[1,0,1,0,1,0,0,1,1,0,1]
 * 输出：3
 * 解释：
 * 交换 3 次，一种可行的只用 3 次交换的解决方案是 [0,0,0,0,0,1,1,1,1,1,1]。
 */
class Solution {
    public int minSwaps(int[] data) {
        //数1的个数
        int count=Arrays.stream(data).sum();
        int number=0,min=Integer.MAX_VALUE;
        //滑动窗口大小限定为count大小 统计窗口内有多少个1
        for (int j = 0,i=0; j < data.length; j++) {
            if (j-i==count) {
                number-=data[i];
                i++;
            }
            number+=data[j];
            min=Math.min(count-number,min);
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minSwaps(new int[]{1,0,1,0,1,0,0,1,1,0,1}));
        System.out.println(new Solution().minSwaps(new int[]{1,0,1,0,1}));
        System.out.println(new Solution().minSwaps(new int[]{0,0,0,1,0}));
    }
}