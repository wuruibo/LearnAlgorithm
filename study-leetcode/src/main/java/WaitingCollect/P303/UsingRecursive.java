package WaitingCollect.P303;

/**
 * 递归的方式
 * @autor yeqiaozhu.
 * @date 2019-08-28
 */
public class UsingRecursive {
    private int[] nums;
    public UsingRecursive(int[] nums) {
        this.nums=nums;
    }

    public int sumRange(int i, int j) {
        if(i==j){
            return nums[i];
        }
        return sumRange(i,j-1)+nums[j];
    }

    public static void main(String[] args) {
        while (true);
    }
}
