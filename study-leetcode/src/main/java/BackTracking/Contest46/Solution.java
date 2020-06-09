package BackTracking.Contest46;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *  
 *
 * 提示：
 *
 * 0 <= num < 231
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int translateNum(int num) {
        //将每个位的数字存入数组
        List<Integer> queue= new LinkedList<>();
        if (num==0) queue.add(num);

        while (num != 0) {
            queue.add(0,num%10);
            num/=10;
        }

        //定义dp问题 dp问题为长度为x的数组有几种可能的字母组合 dp[x]=dp[x-1]+dp[x-2] if x----x-2可以组成一个字符
        int[] dp=new int[queue.size()+1];

        for (int i = 0; i <= queue.size(); i++) {
            if (i<2) {
                dp[i]=i;
                continue;
            }
            int current=queue.get(i-2)*10+queue.get(i-1);
            if (queue.get(i-2)!=0 && current>=0 && current<=25) {
                dp[i]=dp[i-1]+(dp[i-2]==0?1:dp[i-2]);
            }else {
                dp[i]=dp[i-1];
            }
        }

        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().translateNum(0));
        System.out.println(new Solution().translateNum(12258));
        System.out.println(new Solution().translateNum(25));
        System.out.println(new Solution().translateNum(506));
    }
}