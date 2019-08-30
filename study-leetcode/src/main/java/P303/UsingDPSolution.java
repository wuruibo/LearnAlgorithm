package P303;

/**
 * 空间换时间
 * @autor yeqiaozhu.
 * @date 2019-08-28
 */
public class UsingDPSolution {
    private int[] sums;
    public UsingDPSolution(int[] nums) {
        if(nums.length==0){
            return ;
        }
        this.sums=new int[nums.length];
        this.sums[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            int sum=this.sums[i-1]+nums[i];
            this.sums[i]=sum;
        }
    }

    public int sumRange(int i, int j) {
        if(this.sums.length==0){
            return 0;
        }
        return i==0?this.sums[j]:this.sums[j]-this.sums[i-1];
    }

    public static void main(String[] args) {
        int[] nums={-2, 0, 3, -5, 2, -1};
        System.out.println(new UsingDPSolution(nums).sumRange(0,2));
        System.out.println(new UsingDPSolution(nums).sumRange(0,0));
        System.out.println(new UsingDPSolution(nums).sumRange(2,5));
        System.out.println(new UsingDPSolution(nums).sumRange(0,5));
    }
}
