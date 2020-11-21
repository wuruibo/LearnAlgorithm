package DynamicProgramming.P91;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 题目数据保证答案肯定是一个 32 位的整数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2：
 *
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 示例 3：
 *
 * 输入：s = "0"
 * 输出：0
 * 示例 4：
 *
 * 输入：s = "1"
 * 输出：1
 * 示例 5：
 *
 * 输入：s = "2"
 * 输出：1
 *
 * 1. 如果s.charAt(i)!='0' dp[i]=dp[i-1]+dp[i-2]
 * 2. 如果s.charAt(i)=='0' dp[i]=dp[i-2];
 */
class Solution {
    public int numDecodings(String s) {
        //可以先消除前面导0
        int n=s.length();
        int[] dp=new int[n+1];
        dp[0]=1;
        for (int j = 1; j <= n; j++) {
            dp[j] = s.charAt(j-1) == '0' ? 0 : dp[j-1];
            if(j > 1 && (s.charAt(j-2) == '1' || (s.charAt(j-2) == '2' && s.charAt(j-1) <= '6'))){
                dp[j] += dp[j-2];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("12"));
        System.out.println(new Solution().numDecodings("230"));
        System.out.println(new Solution().numDecodings("000"));
        System.out.println(new Solution().numDecodings("10011"));
        System.out.println(new Solution().numDecodings("27"));
        System.out.println(new Solution().numDecodings("226"));
        System.out.println(new Solution().numDecodings("0"));
        System.out.println(new Solution().numDecodings("1"));
        System.out.println(new Solution().numDecodings("2"));
    }
}