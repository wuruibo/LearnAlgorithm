package Contest.Contest39.Problem3;

/**
 *
 * 生成平衡数组的方案数
 * 6 7 4 1
 * 6 7
 * 4 1
 * 类似前缀和的思想
 */
class Solution {
    public int waysToMakeFair(int[] nums) {
        int n=nums.length,result=0;
        int[][] pre=new int[n+1][2];
        for (int i = 1; i <= n; i++) {
            if ((i-1)%2==0) {
                pre[i][1]=pre[i-1][1];
                pre[i][0]=pre[i-1][0]+nums[i-1];
            }else {
                pre[i][0]=pre[i-1][0];
                pre[i][1]=pre[i-1][1]+nums[i-1];
            }
        }

        //删除任何一个点 左边的部分不变 右边的部分减去当前元素 然后基数和偶数调换位置
        for (int i = 0; i < n; i++) {
            //先得到后边元素的元素和
            int left=pre[n][0]-pre[i][0];//偶数
            int right=pre[n][1]-pre[i][1];//基数
            if (i%2==0) {
                left-=nums[i];
            }else {
                right-=nums[i];
            }
            //判断一下
            if (pre[i][0]+right==pre[i][1]+left) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().waysToMakeFair(new int[]{6, 7, 4, 1}));
        System.out.println(new Solution().waysToMakeFair(new int[]{1,1,1}));
        System.out.println(new Solution().waysToMakeFair(new int[]{1,2,3}));
    }
}