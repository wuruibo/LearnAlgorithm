package WaitingCollect.P152;

class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length ==0){
            return 0;
        }else if(nums.length==1){
            return nums[0];
        }else {
            int tempMax=nums[0];
            int tempMin=nums[0];

            int maxProduct=nums[0];
            for(int i=1;i<nums.length;i++){
                if(nums[i]<0) {
                    int temp=tempMax;
                    tempMax=tempMin;
                    tempMin=temp;
                }
                tempMax=Math.max(tempMax*nums[i],nums[i]);
                tempMin=Math.min(tempMin*nums[i],nums[i]);

                maxProduct=Math.max(maxProduct,tempMax);
            }
            return maxProduct;
        }
        
    }

    public static void main(String[] args) {
        int[] ints={-2,0,-1};
        System.out.println(new Solution().maxProduct(ints));
    }
}