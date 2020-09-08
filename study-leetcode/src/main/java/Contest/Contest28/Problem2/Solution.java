package Contest.Contest28.Problem2;

/**
 * 给你一个二进制串 s  （一个只包含 0 和 1 的字符串），我们可以将 s 分割成 3 个 非空 字符串 s1, s2, s3 （s1 + s2 + s3 = s）。
 *
 * 请你返回分割 s 的方案数，满足 s1，s2 和 s3 中字符 '1' 的数目相同。
 *
 * 由于答案可能很大，请将它对 10^9 + 7 取余后返回。
 * 示例 1：
 *
 * 输入：s = "10101"
 * 输出：4
 * 解释：总共有 4 种方法将 s 分割成含有 '1' 数目相同的三个子字符串。
 * "1|010|1"
 * "1|01|01"
 * "10|10|1"
 * "10|1|01"
 * 示例 2：
 *
 * 输入：s = "1001"
 * 输出：0
 * 示例 3：
 *
 * 输入：s = "0000"
 * 输出：3
 * 解释：总共有 3 种分割 s 的方法。
 * "0|0|00"
 * "0|00|0"
 * "00|0|0"
 * 示例 4：
 *
 * 输入：s = "100100010100110"
 * 输出：12
 */
class Solution {
    public int numWays(String s) {
        long sum=s.chars().map(arg->arg-'0').sum(),time=3;
        long mod=(long)(Math.pow(10,9)+7),tempSum=0;;
        if (sum==0) {
            return (int) ((((long)s.length()-1)*((long)s.length()-2))/2%mod);
        }else if(sum%time!=0){
            return 0;
        }
        long target=sum/3,left=0,right=0;
        //从左往右找到平均和的可能性
        for (int i = 0; i < s.length(); i++) {
            tempSum+=(s.charAt(i)-'0');
            if (tempSum==target) {
                left++;
            }
        }
        //从右往左找到平均和的可能性
        tempSum=0;
        for (int j = s.length()-1; j >= 0; j--) {
            tempSum+=(s.charAt(j)-'0');
            if (tempSum==target) {
                right++;
            }
        }
        return (int) ((left*right)%mod);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numWays("10101"));
        System.out.println(new Solution().numWays("1001"));
        System.out.println(new Solution().numWays("0000"));
        System.out.println(new Solution().numWays("100100010100110"));
    }
}