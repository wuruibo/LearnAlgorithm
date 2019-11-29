package WaitingCollect.P560;

class Solution {
    private int[] nums;
    public int subarraySum(int[] nums, int k) {
        this.nums=nums;
        return maxArraySum(nums.length-1,k);
    }
    public int maxArraySum(int i,int k){
        if (i==0) {
            return nums[0]==k?1:0;
        }
        return maxArraySum(i-1,k)+tempArraySum(i-1,k-nums[i])+(nums[i]==k?1:0);
    }

    public int tempArraySum(int i,int k){
        if (i==0) {
            return nums[0]==k?1:0;
        }
        return tempArraySum(i-1,k-nums[i])+(nums[i]==k?1:0);
    }

    public static void main(String[] args) {
        int[] nums={1,1,1};
        new Solution().subarraySum(nums,2);
    }
}