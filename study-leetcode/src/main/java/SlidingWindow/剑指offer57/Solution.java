package SlidingWindow.剑指offer57;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *  
 *
 * 限制：
 *
 * 1 <= target <= 10^5
 *
 */
class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> result= new ArrayList<>();
        //滑动窗口
        int first=1,tempSum=0;
        for (int second = 1; second <= target; second++) {
            tempSum+=second;
            while (tempSum > target) {
                tempSum-=first++;
            }
            if (tempSum==target && second-first>=1) {
                int[] param=IntStream.rangeClosed(first,second).toArray();
                result.add(param);
            }
        }
        //将List<int[]> 转为int[][]
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findContinuousSequence(9).toString());
        System.out.println(new Solution().findContinuousSequence(15).toString());
    }
}