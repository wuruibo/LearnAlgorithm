package Array.前缀和.P523;

/**
 * 523. 连续的子数组和
 * 给定一个包含 非负数 的数组和一个目标 整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，且总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[23,2,4,6,7], k = 6
 * 输出：True
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6。
 * 示例 2：
 *
 * 输入：[23,2,6,4,7], k = 6
 * 输出：True
 * 解释：[23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
 *
 *
 * 说明：
 *
 * 数组的长度不会超过 10,000 。
 */
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        //先统计前缀和
        int[] tempSum=new int[nums.length+1];
        int subSum=0;
        for (int i = 0; i < tempSum.length; i++) {
            if (i==0) {
                tempSum[i]=0;
                continue;
            }
            tempSum[i]=(subSum+=nums[i-1]);
        }

        //遍历前缀和
        for (int i = 0; i < tempSum.length; i++) {
            Integer rightSum=tempSum[i];
            for (int j = 0; j <=(i-2) ; j++) {
                Integer sum=rightSum-tempSum[j];
                if (k!=0 && sum%k==0) {
                    return true;
                }else if (k==0 && sum==0){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array={2,6,3,4,1};
        System.out.println(new Solution().checkSubarraySum(array, 0));

        int[] array1={23,2,6,4,7};
        System.out.println(new Solution().checkSubarraySum(array1, 6));
    }
}