package Contest.Contest12.Problem2;

/**
 * 因为轴对称，所以取绝对值统一往右移动
 * 计算当前步数能到达右边的所有位置
 * 1: 1
 * 2: 3, 1
 * 3: 6, 4, 2, 0
 * 4: 10, 8, 6, 4, 0
 * 5: 15, 13, 11, 9, 7, 5, 3, 1
 * 可以看出当前步能到达的位置相邻间隔2
 * 所以只需要找到最小的步数，满足他的最大位置>=target并且两者奇偶性相同即可
 */
public class Solution {
    public int reachNumber(int target) {
        target=Math.abs(target);
        int maxPos=0;
        int steps=1;
        while (target>maxPos||(maxPos-target)%2!=0)
            maxPos+=steps++;
        return steps-1;
    }
}
