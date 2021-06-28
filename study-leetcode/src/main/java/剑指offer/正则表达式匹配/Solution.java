package 剑指offer.正则表达式匹配;

class Solution {
    public boolean isMatch(String s, String p) {
        //状态 dp[i][j]表示s中i之前的和p中j之前的子串是否可以匹配
        //状态转移 1.p[j]=='.'    dp[i][j]=dp[i-1][j-1]
        //       2.p[j]==s[i]  dp[i][j]=dp[i-1][j-1]
        //       3.p[j]=='*' && p[j-1]!='.'   dp[i][j]=dp[i1][j1]  i1和j1位当前s和p中第一个不为可替换字符的索引
        //       4.p[j]=='*' && p[j-1]=='.'   dp[i][j] = dp[i][j] || dp[i1-1][j-3] 所有i1为不等于i但是s[i1]==p[j-2]
        //考虑初始化 s长度为0的时候 p如果全部都是* true 其他情况均默认false
        int m=s.length(),n=p.length();
        boolean[][] dp=new boolean[m+1][n+1];
        //初始化 "" "c*a*" 是true
        dp[0][0]=true;
        for (int j = 1; j <= n; j++) {
            if(p.charAt(j-1)=='*'){
                dp[0][j]=dp[0][j-2];
            }
        }
        //开始匹配
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pj=p.charAt(j-1);
                char si=s.charAt(i-1);
                if(pj==si || pj=='.'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(pj=='*'){
                    //找到第一个不为*的索引 忽略多余的* 这步可以省略 题目保证无连续的*
                    int j1=j-1;
                    //如果j1为空字符 不处理
                    if(j1==0){
                        continue;
                    }
                    //如果j1为普通字符
                    if(p.charAt(j1-1)!='.'){
                        //p中当前a*可以替换s中所有的后置a
                        dp[i][j]=dp[i][j-2];
                        int i2=i;
                        while(i2>0 && s.charAt(i2-1)==p.charAt(j1-1)){
                            i2--;
                            dp[i][j]=dp[i][j] || dp[i2][j-2];
                        }
                        continue;
                    }
                    //如果j1为'.' 意味着s中任意的串儿都能被换 直接遍历s所有的可能性
                    for (int k = 0; k <= i; k++) {
                        dp[i][j]= dp[i][j] || dp[k][j-2];
                    }   
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().isMatch("aab", "c*a*b"));
        System.out.println(new Solution().isMatch("aaa","ab*a*c*a"));
    }
}