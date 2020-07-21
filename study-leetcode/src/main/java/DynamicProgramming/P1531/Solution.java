package DynamicProgramming.P1531;

/**
 * 类似最长递增子序列
 * 统计以当前位置为结尾的子串数量然后进行累加
 *
 */
class Solution {
    public int numSub(String s) {
        int strLength = s.length();
        int[] temp = new int[strLength];
        temp[strLength - 1] = s.charAt(strLength - 1) == '1' ? 1 : 0;
        for (int i = strLength - 2; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '1') {
                temp[i] = 1 + temp[i + 1];
            }
        }
        int ans = 0;
        for (int i : temp) {
            ans = (ans + i)% 1000000007;
        }
        return ans ;
    }

}
