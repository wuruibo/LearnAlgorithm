package 剑指offer.按摩师;

/**
 * @author yeqiaozhu
 * @date today
 */
public class NoSpace {
    public int massage(int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        }
        if (nums.length==1) {
            return nums[0];
        }
        if (nums.length==2) {
            return Math.max(nums[0],nums[1]);
        }
        int pre=nums[0],current=Math.max(nums[0],nums[1]),max=0;
        for (int i = 2; i < nums.length; i++) {
            max=Math.max(max,pre+nums[i]);
            max=Math.max(max,current);

            pre=current;
            current=max;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new NoSpace().massage(new int[]{1}));
        System.out.println(new NoSpace().massage(new int[]{1,2,3,1}));
        System.out.println(new NoSpace().massage(new int[]{2,7,9,3,1}));
        System.out.println(new NoSpace().massage(new int[]{2,1,4,5,3,1,1,3}));
    }
}
