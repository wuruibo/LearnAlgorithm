package WaitingCollect.P53;

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length ==0){
            return 0;
        }else if(nums.length==1){
            return nums[0];
        }else {
            int[] tempMaxArray=new int[nums.length];
            int[] maxArray=new int[nums.length];
            tempMaxArray[0]=nums[0];
            maxArray[0]=nums[0];
            for (int i = 1; i < nums.length; i++) {
                tempMaxArray[i]=findMax(tempMaxArray[i-1]+nums[i],nums[i]);
                maxArray[i]=findMax(maxArray[i-1],tempMaxArray[i]);
            }
            return maxArray[nums.length-1];
        }
    }

    public int findMax(int first,int second){
        return first>second?first:second;
    }

    public static void main(String[] args) {
        int[] ints={1,3,-4,5};
        System.out.println(new Solution().maxSubArray(ints));
    }
}