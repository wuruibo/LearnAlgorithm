package WaitingCollect.P198;

/**
 * 动态规划
 * @autor yeqiaozhu.
 * @date 2019-08-28
 */
public class UsingDPSolution {
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        //定义一个robs数组，存储0-i数组的最优解
        int[] robs= new int[nums.length];
        robs[0]=nums[0];
        robs[1]=max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            robs[i]=max(robs[i-2]+nums[i],robs[i-1]);
        }
        return robs[nums.length-1];
    }
    public int max(int a,int b){
        return a>b?a:b;
    }

    public static void main(String[] args) {
        int[] num={2,7,9,3};
        System.out.println(new UsingDPSolution().rob(num));
    }
}
