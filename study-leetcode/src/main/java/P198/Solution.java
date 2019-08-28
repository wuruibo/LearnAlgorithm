package P198;

/**
 * using recursive
 * 时间复杂度n2
 * 抢劫房屋问题
 */
class Solution {
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        return robDigui(nums,nums.length-1);
    }
    //定义递归方法
    public int robDigui(int[] nums,int i){
        if(i==0){
            return nums[0];
        } else if(i==1){
            return max(nums[0],nums[1]);
        } else {
            return max(robDigui(nums,i-2)+nums[i],robDigui(nums,i-1));
        }
    }
    public int max(int a,int b){
        return a>b?a:b;
    }

    public static void main(String[] args) {
        int[] num={2,7,9,3};
        System.out.println(new Solution().rob(num));
    }
}