package BackTracking.P139;

import java.util.*;

/**
 * dp[i]表示字符串0-i的字符串是否能组合出现
 * 那么可以得到dp[i]=dp[i-1] && set.contains(s.subString(i-1,i))
 * 当i=0是为true
 * @autor yeqiaozhu.
 * @date 2019-11-13
 */
public class UsingDP {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dicSet= new HashSet<>();
        dicSet.addAll(wordDict);

        //定义dp数组
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i-1; j >= 0; j--) {
                dp[i]=dp[j] && dicSet.contains(s.substring(j,i));
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        List<String> temp= new ArrayList<>();

        String test= "leet,code";
        Arrays.stream(test.split(",")).forEach(s -> temp.add(s));
        new UsingDP().wordBreak("leetcode",temp);

    }
}
