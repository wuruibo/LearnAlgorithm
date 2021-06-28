package 解题群.仙仙计算;

class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n=nums.length;
        //计算前缀和数组
        long[] preSum=new long[n+1];
        for(int i=1;i<=n;i++){
            preSum[i]=preSum[i-1]+nums[i-1];
        }
        //计算每个区间内的最小和的最大值
        long max=0;
        for(int i=1;i<=n;i++){
            int min=nums[i-1];
            for(int j=i;j<=n;j++){
                min=Math.min(min,nums[j-1]);
                long tempMax=(preSum[j]-preSum[i-1])*min;
                if(tempMax>max){
                    max=tempMax;
                }
            }
        }
        return (int)(max%1000000007);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSumMinProduct(new int[]{1,2,3,2}));
        System.out.println(new Solution().maxSumMinProduct(new int[]{2,3,3,1,2}));
        System.out.println(new Solution().maxSumMinProduct(new int[]{3,1,5,6,4,2}));
    }

}