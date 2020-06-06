package Array.P41;

/**
 *
 * 通过负数来标记已经出现过的数字（前提是将已有的负数全部转换成正数）
 *
 * 1.当nums[i]<=0 || nums[i]>nums.length+1的时候直接忽略该项目
 * 2.当nums[i]>0 && nums[i]<nums.length+1的时候将对应索引位置的元素取反（这样既可以打上标志又可以防止数据提前覆盖）
 * 3.找出第一个正数的索引位置就是结果
 *
 * Example 1:
 * Input: [1,2,3]   -----> [1,2,3] ------> [-1,2,3] ------>[-1,-2,3]
 * Output: 3
 *
 * Example 2:
 * Input: [3,4,-1,1]---->[3,4,5,1]---->[3,4,-5,1]--->[3,4,-5,-1]--->[-3,4,-5,-1]
 * Output: 2
 *
 * Example 3:
 * Input: [7,8,9,11,12]--->[7,8,9,11,12]
 * Output: 1
 *
 * Example 4:
 * Input: [2,1]--->[2,-1]--->[-2,-1]
 * Output: 3
 *
 * @autor yeqiaozhu.
 * @date 2019-12-24
 */
public class NOSpace {
    public int firstMissingPositive(int[] nums) {
        //step1 将负数专成正数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<=0) {
                nums[i]=nums.length+1;
            }
        }
        //step2 遍历一遍标志一遍（取反）
        for (int j = 0; j < nums.length; j++) {
            int val=Math.abs(nums[j]);
            //当前位置可以被索引到并且索引到的位置的值大于0（防止数组越界/重复覆盖负负得正）
            if (val<nums.length+1 && nums[val-1]>0) {
                nums[val-1]=-1*nums[val-1];
            }
        }
        //step3 找到第一个正数
        int index=nums.length;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k]>0) {
                index=k;
                break;
            }
        }
        return index+1;
    }

    public static void main(String[] args) {
        int[] ints={0,2,2,1,1};
        int[] ints1={2,1};
        int[] ints2={7,8,9,11,12};
        System.out.println(new NOSpace().firstMissingPositive(ints));
        System.out.println(new NOSpace().firstMissingPositive(ints1));
        System.out.println(new NOSpace().firstMissingPositive(ints2));
    }

}
