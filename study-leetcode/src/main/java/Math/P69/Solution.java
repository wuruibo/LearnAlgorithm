package Math.P69;

/**
 * 牛顿迭代法
 * 关键是找到首尾
 * 这里尾巴如果用目标值 可能导致溢出 所以用long
 */
class Solution {
    public int mySqrt(int x) {
        long r = x;
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int) r;
    }
}