package 剑指offer.按摩师;

/**
 * @author yeqiaozhu
 * @date today
 */
public class NoDfs {
    public int massage(int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        }
        int[] dp=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i==0) {
                dp[i]=nums[0];
            }else if (i==1){
                dp[i]=Math.max(nums[i],dp[0]);
            }else {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        System.out.println(new NoDfs().massage(new int[]{1}));
        System.out.println(new NoDfs().massage(new int[]{1,2,3,1}));
        System.out.println(new NoDfs().massage(new int[]{2,7,9,3,1}));
        System.out.println(new NoDfs().massage(new int[]{2,1,4,5,3,1,1,3}));
    }
}
