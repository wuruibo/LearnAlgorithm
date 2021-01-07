package Contest.Contest47.Problem3;

/**
 * 输入：nums = [1,2,2,2,5,0]
 * 输出：3
 * 解释：nums 总共有 3 种好的分割方案：
 * [1] [2] [2,2,5,0]
 * [1] [2,2] [2,5,0]
 * [1,2] [2,2] [5,0]
 */
class Solution {
    public int waysToSplit(int[] nums) {
        int n=nums.length;
        int[] preSum=new int[n+1];
        for (int i = 1; i <= n; i++) {
            preSum[i]=preSum[i-1]+nums[i-1];
        }
        int count=0;
        for (int i = 1; i <= n; i++) {
            //二分搜索左边界和右边界
            int left=preSum[i];
            int start=i+1,end=n-1;
            //找到第一个小于左边的位置
            while (start <= end) {
                int mid=start+((end-start)>>1);
                if (preSum[mid]-preSum[i]<left) {
                    start=mid+1;
                }else {
                    end=mid-1;
                }
            }
            //找到第一个大于右边的位置
            int s=end,e=n-1;
            while (s<=e){
                int m=s+((e-s)>>1);
                if (preSum[m]-preSum[i]>preSum[n]-preSum[m]) {
                    e=m-1;
                }else {
                    s=m+1;
                }
            }
            count+=e>=start?e-start+1:0;
            count%=1000000007;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().waysToSplit(new int[]{0,3,3}));
        System.out.println(new Solution().waysToSplit(new int[]{1, 2, 2, 2, 5, 0}));
        System.out.println(new Solution().waysToSplit(new int[]{1,1,1}));
        System.out.println(new Solution().waysToSplit(new int[]{3,2,1}));
    }
}