package Contest.Contest46.Problem2;

/**
 * 输入：nums = [1,4,6,8,10]
 * 输出：[24,15,13,15,21]
 */
class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n=nums.length;
        int[] preSum=new int[n+1];
        for (int i = 1; i <= n; i++) {
            preSum[i]=preSum[i-1]+nums[i-1];
        }
        //开始统计
        int[] result=new int[n];
        for (int i = 1; i <= n; i++) {
            int left=nums[i-1]*i-preSum[i];
            int right=preSum[n]-preSum[i]-nums[i-1]*(n-i);

            result[i-1]=left+right;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getSumAbsoluteDifferences(new int[]{1,4,6,8,10}));
        System.out.println(new Solution().getSumAbsoluteDifferences(new int[]{2,3,5}));
        System.out.println(new Solution().getSumAbsoluteDifferences(new int[]{2}));
    }
}