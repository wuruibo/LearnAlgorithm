package 剑指offer.坤宝动态规划;

/**
 * @author yeqiaozhu
 */
public class Solution {
    public int kunBao(String s){
        int[] dp=new int[s.length()];
        int max=0;
        for (int i = 0; i < s.length(); i++) {
            Character current=s.charAt(i);
            if (i==0) {
                dp[i]=current.equals(' ')?0:1;
            }else {
                dp[i]=current.equals(' ')?0:dp[i-1]+1;
            }
            max=Math.max(dp[i],max);
        }
        return max;
    }
    public int kunBaoNoSpace(String s){
        int pre=0,max=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==' ') {
                pre=0;
            }else {
                max=Math.max(pre+1,max);
                pre=pre+1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().kunBao("aa aa aaaa aaa a a a aa aa a"));
        System.out.println(new Solution().kunBaoNoSpace("aa aa aaaa aaa a a a aa aa a"));
    }
}
