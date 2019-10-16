package P581;

/**
 * 两次遍历
 * 遍历的过程中保存最大值和最小值
 * 判断当前的值大于这个最大值的时候就是end位置
 * 判断当前的值小于这个最小值的时候就是begin位置
 * @autor yeqiaozhu.
 * @date 2019-10-15
 */
public class UsingOneCircle {
    public int findUnsortedSubarray(int[] nums) {
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        int end=-1;int begin=0;
        for (int i = 0; i < nums.length; i++) {
            max=Math.max(max,nums[i]);
            if (nums[i]<max) {
                end=i;
            }
        }

        for (int j = nums.length-1; j >=0; j--) {
            min=Math.min(min,nums[j]);
            if (nums[j]>min) {
                begin=j;
            }
        }
        return end-begin+1;
    }

    public static void main(String[] args) {
        int[] ints={5,4,3,2,1};
        System.out.println(new UsingOneCircle().findUnsortedSubarray(ints));
    }
}
