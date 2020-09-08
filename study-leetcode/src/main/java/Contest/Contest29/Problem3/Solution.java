package Contest.Contest29.Problem3;

/**
 * 示例 1：
 *
 * 输入：s = "abaac", cost = [1,2,3,4,5]
 * 输出：3
 * 解释：删除字母 "a" 的成本为 3，然后得到 "abac"（字符串中相邻两个字母不相同）。
 * 示例 2：
 *
 * 输入：s = "abc", cost = [1,2,3]
 * 输出：0
 * 解释：无需删除任何字母，因为字符串中不存在相邻两个字母相同的情况。
 * 示例 3：
 *
 * 输入：s = "aabaa", cost = [1,2,3,4,1]
 * 输出：2
 * 解释：删除第一个和最后一个字母，得到字符串 ("aba") 。
 *
 *
 * 提示：
 *
 * s.length == cost.length
 * 1 <= s.length, cost.length <= 10^5
 * 1 <= cost[i] <= 10^4
 * s 中只含有小写英文字母
 */
class Solution {
    public int minCost(String s, int[] cost) {
        int minCost=0;
        for (int i = 0; i < s.length()-1;i++) {
            int count=cost[i],maxCost=cost[i];
            while (i<s.length()-1 && s.charAt(i)==s.charAt(i+1)) {
                count+=cost[i+1];
                maxCost=Math.max(maxCost,cost[i+1]);
                i++;
            }
            minCost+=count-maxCost;
        }
        return minCost;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minCost("abaac", new int[]{1, 2, 3, 4, 5}));
        System.out.println(new Solution().minCost("abc", new int[]{1, 2, 3}));
        System.out.println(new Solution().minCost("aabaa", new int[]{1, 2, 3, 4, 1}));
        System.out.println(new Solution().minCost("aaabbbabbbb",new int[]{3,5,10,7,5,3,5,5,4,8,1}));
    }
}