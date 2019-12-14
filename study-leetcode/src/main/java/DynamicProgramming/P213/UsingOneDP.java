package DynamicProgramming.P213;

/**
 * 如果input为{1,7,9,2}实际上只需要求出{1,7,9}的最大值和{7,9,2}的最大值，输出最大的那个就行了
 * House Robber II在House Robber的基础上求解
 * @autor yeqiaozhu.
 * @date 2019-12-13
 */
public class UsingOneDP {
    public int rob(int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        }
        if (nums.length==1) {
            return nums[0];
        }
        return Math.max(robI(nums,0,nums.length-2),robI(nums,1,nums.length-1));
    }
    private int robI(int[] nums,int start,int end) {
        if(end<start){
            return 0;
        }
        //定义一个robs数组，存储0-i数组的最优解
        int[] robs= new int[end-start+1];
        for(int i=start;i<=end;i++){
            if (i==start) {
                robs[i-start]=nums[i];
            }else if(i==start+1){
                robs[i-start]=Math.max(nums[start],nums[start+1]);
            }else {
                robs[i-start] = Math.max(robs[i - 2-start] + nums[i], robs[i - 1-start]);
            }
        }
        return robs[robs.length-1];
    }
    public static void main(String[] args) {
        int[] nums={1,7,9,2};
        System.out.println(new UsingOneDP().rob(nums));

        int[] nums1={2,3,2};
        System.out.println(new UsingOneDP().rob(nums1));
    }
}
