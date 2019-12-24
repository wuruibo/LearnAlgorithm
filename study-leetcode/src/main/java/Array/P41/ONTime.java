package Array.P41;

/**
 *
 * 需要创建一个状态存储的数组target(防止元素覆盖)
 *
 * Example 1:
 * Input: [1,2,0]   -----> [0,0,0] ------> [1,0,0] ------>[1,2,0]
 * Output: 3
 *
 * Example 2:
 * Input: [3,4,-1,1]---->[0,0,3,0]---->[0,0,3,4]--->[1,0,3,4]
 * Output: 2
 *
 * Example 3:
 * Input: [7,8,9,11,12]--->[0,0,0,0,0]
 * Output: 1
 *
 * Example 4:
 * Input: [2,1]--->[0,0]--->[0,2]--->[1,2]
 * Output: 3
 *
 * @autor yeqiaozhu.
 * @date 2019-12-24
 */
public class ONTime {
    public int firstMissingPositive(int[] nums) {
        //step1 复制数组
        int[] target=new int[nums.length];
        //step2 遍历一遍nums数组
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0 && nums[i]<nums.length+1) {
                target[nums[i]-1]=nums[i];
            }
        }
        //遍历第一个小于0的index位置
        int index=nums.length;
        for (int j = 0; j < nums.length; j++) {
            if (target[j]!=j+1) {
                index=j;
                break;
            }
        }
        return index+1;
    }

    public static void main(String[] args) {
        //int[] ints={0,2,2,1,1};
        int[] ints1={2,1};
        int[] ints2={7,8,9,11,12};
        //System.out.println(new ONTime().firstMissingPositive(ints));
        System.out.println(new ONTime().firstMissingPositive(ints1));
        System.out.println(new ONTime().firstMissingPositive(ints2));
    }
}