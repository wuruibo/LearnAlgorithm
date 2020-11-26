package SlidingWindow.P1208;

/**
 * 输入：s = "abcd", t = "bcdf", cost = 3
 * 输出：3
 * 解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
 * 示例 2：
 *
 * 输入：s = "abcd", t = "cdef", cost = 3
 * 输出：1
 * 解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
 * 示例 3：
 *
 * 输入：s = "abcd", t = "acde", cost = 0
 * 输出：1
 * 解释：你无法作出任何改动，所以最大长度为 1。
 */
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int cost=0,max=0;
        for (int r = 0,l=0; r < s.length(); r++) {
            //往右边添加
            cost+=Math.abs(t.charAt(r)-s.charAt(r));
            while (cost > maxCost) {
                cost-=Math.abs(t.charAt(l)-s.charAt(l));
                l++;
            }
            max=Math.max(max,r-l+1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().equalSubstring("abcd", "bcdf", 3));
        System.out.println(new Solution().equalSubstring("abcd", "cdef", 3));
        System.out.println(new Solution().equalSubstring("abcd", "acde", 0));
        System.out.println(new Solution().equalSubstring("krrgw" ,"zjxss", 19));
    }
}