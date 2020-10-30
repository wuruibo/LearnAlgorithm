package Array.前缀和.P307;

class NumArray {
    private int[] subNums;
    private int[] nums;
    public NumArray(int[] nums) {
        this.nums=nums;
        subNums=new int[nums.length+1];
        for (int i = 1; i <= nums.length; i++) {
            subNums[i]=nums[i-1]+subNums[i-1];
        }
    }
    
    public void update(int i, int val) {
        this.nums[i]=val;
        subNums=new int[nums.length+1];
        for (int j = 1; j <= nums.length; j++) {
            subNums[j]+=nums[j-1]+subNums[j-1];
        }
    }
    
    public int sumRange(int i, int j) {
        return subNums[j+1]-subNums[i];
    }

    public static void main(String[] args) {
        NumArray numArray=new NumArray(new int[]{-1});
        System.out.println(numArray.sumRange(0,0));
        numArray.update(0,1);
        System.out.println(numArray.sumRange(0,0));
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */