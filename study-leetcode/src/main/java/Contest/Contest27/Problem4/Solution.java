package Contest.Contest27.Problem4;

public class Solution {
    public int stoneGameV(int[] stoneValue) {
        int N = stoneValue.length;
        int[][] dp = new int[N][N];

        //前缀和
        int[] preSum= new int[N];
        preSum[0]=stoneValue[0];
        for (int i = 1; i < stoneValue.length; i++) {
            preSum[i] =preSum[i-1]+stoneValue[i];
        }

        //区间dp
        for (int len = 2; len <=N ; len++) {
            for (int i = 0; i+len-1 <N ; i++) {
                int j = i+len-1;
                for (int m = i; m <=j ; m++) {
                    if (i>m || m+1>j){
                        continue;
                    }
                    int l,r,ls,rs;
                    //左区间
                    l = dp[i][m];
                    //右区间
                    r = dp[m+1][j];
                     // i ~ m 分数
                    ls = preSum[m] - ((i > 0) ? preSum[i - 1] : 0);
                    //m+1 ~ j 分数
                    rs= preSum[j]- preSum[m];

                    //case 1: Alice决定丢那行
                    if (ls == rs){
                        int score = Math.max(l,r)+ls;
                        dp[i][j] = Math.max(dp[i][j],score);
                    }
                    //case 2: Bob丢掉最大的，Alice只能选剩下的
                    else{
                        if (ls>rs){
                            dp[i][j] = Math.max(dp[i][j],r+rs);
                        }else{
                            dp[i][j] = Math.max(dp[i][j],l+ls);
                        }
                    }
                }
            }

        }
        return dp[0][N-1];
    }
}
