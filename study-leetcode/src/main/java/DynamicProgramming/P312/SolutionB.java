package DynamicProgramming.P312;

/**
 * 自底向上进行思考,向将i j的区间进行不断向下分治的过程。
 * 1.第一层循环 从0～len-1的长度i
 * 2.第二层循环 从0~len-i
 * 3.第三层循环 每层循环里面找到当前i j区间的最优解
 */
public class SolutionB {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] newNums=new int[n+2];
        int[][] dp=new int[n+2][n+2];
        for (int i = 0; i < newNums.length; i++) {
            if (i==0 || i==newNums.length-1) {
                newNums[i]=1;
            }else {
                newNums[i] = nums[i - 1];
            }
        }
        nums=newNums;
        for (int len = 1; len <= n; ++len) {
            // i <= n - len (n - 1) + 1
            for (int i = 1; i <= n - len + 1; ++i) {
                int j = i + len - 1;
                for (int k = i; k <= j; ++k) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + dp[k + 1][j] + nums[k] * nums[i - 1] * nums[j + 1]);
                }
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {
        System.out.println(new SolutionB().maxCoins(new int[]{3,1,5,8}));
        System.out.println(new SolutionB().maxCoins(new int[]{7,9,8,0,7,1,3,5,5,2}));
        System.out.println(new SolutionB().maxCoins(new int[]{8,2,6,8,9,8,1,4,1,5,3,0,7,7,0,4,2,2,5}));    }
}
